package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ Future, ExecutionContext }

/**
 * A repository for workflows.
 *
 * @param dbConfigProvider The Play db config provider. Play will inject this for you.
 */
@Singleton
class WorkflowRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
   * Here we define the table. It will have a name of workflows
   */
  private class WorkflowsTable(tag: Tag) extends Table[Workflow](tag, "workflow") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def number_of_steps = column[Int]("number_of_steps")

    /**
     * This is the tables default "projection".
     *
     * It defines how the columns are converted to and from the Workflow object.
     */
    def * = (id, number_of_steps) <> ((Workflow.apply _).tupled, Workflow.unapply)
  }

  /**
   * The starting point for all queries on the people table.
   */
  private val workflows = TableQuery[WorkflowsTable]

  /**
   * Create a workflow
   *
   * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
   * id for that person.
   */
  def create(number_of_steps: Int): Future[Workflow] = db.run {
    (workflows.map(p => (p.number_of_steps))
      returning workflows.map(_.id)
      into ((number_of_steps, id) => Workflow(id, number_of_steps))
    ) += (number_of_steps)
  }

  def getNumberOfSteps(id: Long): Future[Int] = {
    val q: Query[WorkflowsTable, Workflow, Seq] = workflows.filter(_.id === id)
    val result: Future[Seq[Workflow]] = db.run(q.result)
    result.flatMap( x => Future(x.head.number_of_steps) )
  }

  def list(): Future[Seq[Workflow]] = db.run {
    workflows.result
  }
}
