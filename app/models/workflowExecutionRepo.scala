package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import org.joda.time.DateTime
import models._

import scala.concurrent.{ Future, ExecutionContext, Await }
import scala.concurrent.duration._

/**
 * A repository for workflowExecutions.
 *
 *    http://slick.lightbend.com/doc/3.0.0/queries.html  <- for queries guide
 *
 * @param dbConfigProvider
 */

@Singleton
class WorkflowExecutionRepository @Inject() (dbConfigProvider: DatabaseConfigProvider,
                                              repo: WorkflowRepository
                                            )(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig._
  import profile.api._

  private class WorkflowExecutionsTable(tag: Tag) extends Table[WorkflowExecution](tag, "workflow_execution") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def workflow_id = column[Long]("workflow_id")
    def current_step_index = column[Int]("current_step_index")
    def creation_timestamp = column[String]("creation_timestamp")

    def * = (id, workflow_id, current_step_index, creation_timestamp) <> ((WorkflowExecution.apply _).tupled, WorkflowExecution.unapply)
  }

  private val workflowExecutions = TableQuery[WorkflowExecutionsTable]

  def create(workflow_id: Long, current_step_index: Int, creation_timestamp: String): Future[WorkflowExecution] = db.run {
    (workflowExecutions.map(p => (p.workflow_id, p.current_step_index, p.creation_timestamp))
      returning workflowExecutions.map(_.id)
      into ((otherValues, id) => WorkflowExecution(id, otherValues._1, otherValues._2, otherValues._3))
    ) += (workflow_id, current_step_index, creation_timestamp)
  }

  def list(): Future[Seq[WorkflowExecution]] = db.run {
    workflowExecutions.result
  }

  def workflowExecutionExist(id: Long): Boolean = {
    Await.result(db.run(workflowExecutions.filter(i => i.id === id).exists.result), 3 seconds)
  }

  def increment(id: Long): Future[Seq[WorkflowExecution]] = {
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === id)
    val result: Future[Seq[WorkflowExecution]] = db.run(q.result)
    result.flatMap( x => db.run(workflowExecutions.filter(_.id === id)
            .update(WorkflowExecution(id, x.head.workflow_id, x.head.current_step_index + 1, x.head.creation_timestamp))))
    //result onComplete { case r => println("Updating: " + r)}
    result
  }

  def getCurrentStep(id: Long): Future[Int] = {
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === id)
    val result: Future[Seq[WorkflowExecution]] = db.run(q.result)
    //result onComplete { case r => println("mmmm " + r)}
    result.flatMap( x => Future(x.head.current_step_index) )
  }

  def getWorkflowId(id: Long): Future[Long] = {
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === id)
    val result: Future[Seq[WorkflowExecution]] = db.run(q.result)
    result.flatMap( x => Future(x.head.workflow_id) )
  }

  def getOldIds(): Future[Seq[WorkflowExecution]] = {
    val dateTime: DateTime = new DateTime().minusMinutes(1);
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions
            .filter(_.creation_timestamp < dateTime.toString())
    val result: Future[Seq[WorkflowExecution]] = db.run(q.result)
    result
  }

  def checkDbIfFinished(workflow_execution_id: Long): Boolean = {
    val workflowId = Await.result(getWorkflowId(workflow_execution_id), 3 seconds)
    Await.result(getCurrentStep(workflow_execution_id), 3 seconds) >=
    Await.result(repo.getNumberOfSteps(workflowId), 3 seconds)
  }

  def deleteWorkflowExecution(id: Long): Unit = {
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === id)
    val action = q.delete
    val affectedRowsCount: Future[Int] = db.run(action)
    val sql = action.statements.head
  }

}
