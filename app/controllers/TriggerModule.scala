package controllers

import java.util.UUID

import models.ScheduleRepository

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random
import play.api.libs.json.{JsValue, Json}
import Aliases._

object Aliases {
  type InitToken = String
  type WorkflowUuid = String
  type ExecutionUuid = String
}


trait TriggerInitialization {
  def initialize(initInputJson: String, workflowUuid: WorkflowUuid)(implicit ec: ExecutionContext): Future[Unit] = {
    println(initInputJson)
    println(workflowUuid)
    val json: JsValue = Json.parse(initInputJson)
    scheduleRepository.create((json \ "time_interval_ms").as[Long], workflowUuid).map(n => ())
  }
  val scheduleRepository: ScheduleRepository
}


class WorkflowTriggering {
  def invokeScheduledTrigger(workflowUuid: WorkflowUuid): Future[String] = {
    if (Random.nextInt(10) > 7) {
      Future.failed(new RuntimeException("Failed to run!"))
    } else {
      Future.successful(UUID.randomUUID().toString)
    }
  }
}

