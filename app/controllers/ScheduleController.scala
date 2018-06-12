package controllers

import javax.inject._
import models._
import org.joda.time.DateTime
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class ScheduleController @Inject()(repo: ScheduleRepository,
                                   repo2: WorkflowRepository,
                                   cc: MessagesControllerComponents
                                  )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val scheduleForm: Form[CreateScheduleForm] = Form {
    mapping(
      //"id" -> number.verifying(min(0)),
      "time_interval_ms" -> number,
      "workflowUuid" -> nonEmptyText
     // "last_trigger" -> nonEmptyText,
     // "next_trigger" -> nonEmptyText
    )(CreateScheduleForm.apply)(CreateScheduleForm.unapply)
  }

  /*def index = Action { implicit request =>
    Ok(views.html.schedule(scheduleForm))
  }
*/
  def addSchedule = Action.async { implicit request =>
    scheduleForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok("Format error: " + errorForm))
      },
      schedule => {
        /*if (repo2.workflowExist(schedule.workflowUuid)) {
          // TODO: this checks if workflow exists - need to refactor in the next version
        }*/
        repo.create(schedule.time_interval_ms, schedule.workflowUuid).map { _ =>
          val res = "Response: schedule created"
          println(new DateTime().toString() + " " + res)
          Ok(Json.toJson(res))
        }
      }
    )
  }


  def getSchedules = Action.async { implicit request =>
    repo.list().map { schedules =>
      Ok(Json.toJson(schedules))
    }
  }

}

case class CreateScheduleForm(time_interval_ms: Int, workflowUuid: String)
