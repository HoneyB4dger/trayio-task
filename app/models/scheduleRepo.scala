package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class ScheduleRepository @Inject() (dbConfigProvider: DatabaseConfigProvider,
                                             repo: WorkflowRepository
                                            )(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig._
  import profile.api._

  private class ScheduleTable(tag: Tag) extends Table[Schedule](tag, "schedules") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def time_interval_ms = column[Long]("time_interval_ms")
    def workflowUuid = column[String]("workflowUuid")
    def last_trigger = column[Long]("last_trigger")
    def next_trigger = column[Long]("next_trigger")

    def * = (id, time_interval_ms, workflowUuid, last_trigger, next_trigger) <> ((Schedule.apply _).tupled, Schedule.unapply)
  }

  private val schedules = TableQuery[ScheduleTable]

  def create(time_interval_ms: Long, workflowUuid: String): Future[Schedule] = db.run {
    remove(workflowUuid)
    val last_trigger = 0
    val next_trigger = System.currentTimeMillis + time_interval_ms
    (schedules.map(p => (p.time_interval_ms, p.workflowUuid, p.last_trigger, p.next_trigger))
      returning schedules.map(_.id)
      into ((otherValues, id) => Schedule(id, otherValues._1, otherValues._2, otherValues._3, otherValues._4))
      ) += (time_interval_ms, workflowUuid, last_trigger, next_trigger)
  }

  def list(): Future[Seq[Schedule]] = db.run {
    schedules.result
  }

  def scheduleExist(workflowUuid: String): Future[Seq[Schedule]] = {
    db.run(schedules.filter(i => i.workflowUuid === workflowUuid).result)
  }

  def remove(workflowUuid: String): Unit = {
    val q: Query[ScheduleTable, Schedule, Seq] = schedules.filter(_.workflowUuid === workflowUuid)
    val action = q.delete
    val affectedRowsCount: Future[Int] = db.run(action)
    val sql = action.statements.head
  }

  def getIdsToExecute(): Future[Seq[Schedule]] = {
    db.run(schedules.filter(_.next_trigger <= System.currentTimeMillis).result)
  }

  def updateTimestamps(workflowUuid: String): Unit = {
    val q: Query[ScheduleTable, Schedule, Seq] = schedules.filter(_.workflowUuid === workflowUuid)
    val result: Future[Seq[Schedule]] = db.run(q.result)
    result.flatMap( x => db.run(schedules.filter(_.workflowUuid === workflowUuid)
      .update(Schedule(x.head.id,
        x.head.time_interval_ms,
        x.head.workflowUuid,
        System.currentTimeMillis,
        System.currentTimeMillis + x.head.time_interval_ms))))
  }

}
