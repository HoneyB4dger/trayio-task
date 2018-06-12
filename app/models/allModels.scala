package models

// import java.sql.Timestamp
import play.api.libs.json._

case class Workflow(id: Long, number_of_steps: Int)
case class WorkflowExecution(id: Long, workflow_id: Long, current_step_index: Int, creation_timestamp: String)
case class Schedule(id: Long, time_interval_ms: Long, workflowUuid: String, last_trigger: Long, next_trigger: Long)

object Workflow {
  implicit val workflowFormat = Json.format[Workflow]
}

object WorkflowExecution {
  implicit val workflowExecutionFormat = Json.format[WorkflowExecution]
}

object Schedule {
  implicit val scheduleFormat = Json.format[Schedule]
}