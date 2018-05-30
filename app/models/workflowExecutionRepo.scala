package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import models.WorkflowRepository
import org.joda.time.DateTime

import scala.concurrent.{ Future, ExecutionContext }

/**
 * A repository for workflows.
 *
 *    http://slick.lightbend.com/doc/3.0.0/queries.html  <- for queries guide
 *
 * @param dbConfigProvider The Play db config provider. Play will inject this for you.
 */

@Singleton
class WorkflowExecutionRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
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


  def getLastMinuteIds(): Future[Seq[WorkflowExecution]] = {
    val dateTime: DateTime = new DateTime().minusMinutes(1);
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions
            .filter(_.creation_timestamp < dateTime.toString())
    val result: Future[Seq[WorkflowExecution]] = db.run(q.result)
    result
  }


  def deleteWorkflowExecution(id: Long): Unit = {
    val q: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === id)
    val action = q.delete
    val affectedRowsCount: Future[Int] = db.run(action)
    val sql = action.statements.head
  }
 /**
  *

  def updateNameById(mId: Long) = {
    val sql11: Future[Seq[(Long,Long,Int,String)]] = db.run(sql"""select * from workflow_execution; """.as[(Long,Long,Int,String)])
    println(sql11)
    sql11 onSuccess { case r => println("Updating: " + r)}
    val q = for { l <- workflowExecutions if l.id === mId } yield l.current_step_index
    val w = q.update(4)
    val q1: Query[WorkflowExecutionsTable, WorkflowExecution, Seq] = workflowExecutions.filter(_.id === mId)
    val result: Future[Seq[WorkflowExecution]] = db.run(q1.result)
    result
  }

  def incrementStep(workflow_execution_id: Long): Future[Seq[WorkflowExecution]] = db.run {

    print("*"*80)

    //val q = for { c <- workflowExecutions if c.id === workflow_execution_id } yield c.current_step_index
    //val updateAction = q.update(3)
    //val sql = q.updateStatement

    val newValue = WorkflowExecution(workflow_execution_id, 2, 2, "2");
    workflowExecutions.filter(_.id === workflow_execution_id).update(newValue)
    println("New value:")
    println(newValue)
    println("Filter:")
    val qq = workflowExecutions.filter(_.id === workflow_execution_id).map(_ => ());
    //for { c <- qq if println(c) }

    println()
    //.map(_.current_step_index)
    print("*"*80)
    workflowExecutions.result
    //println(workflowExecutions.filter(_.id === workflow_execution_id))
    //val updateAction = updateWorkflowExecution.update(4)
    //val sql = updateWorkflowExecution.updateStatement
    //workflowExecutions.result
    //updateWorkflowExecution.workflow_id += 1;
  }*/

}
