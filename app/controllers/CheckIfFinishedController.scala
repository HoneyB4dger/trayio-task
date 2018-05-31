package controllers

import javax.inject._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._
import org.joda.time.DateTime

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._

class CheckIfFinishedController @Inject()(repo: WorkflowExecutionRepository,
                                          repo2: WorkflowRepository,
                                          cc: MessagesControllerComponents
                                          )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val checkIfFinishedForm: Form[CheckIfFinishedForm] = Form {
    mapping(
      "workflow_execution_id" -> number.verifying(min(0), max(1024))
    )(CheckIfFinishedForm.apply)(CheckIfFinishedForm.unapply)
  }

  def index = Action { implicit request =>
    Ok(views.html.checkIfFinished(checkIfFinishedForm))
  }

  def checkIfFinished = Action.async { implicit request =>
    checkIfFinishedForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok(views.html.checkIfFinished(errorForm)))
      },
      workflow => {
        if (repo.workflowExecutionExist(workflow.workflow_execution_id)) {
          if (repo.checkDbIfFinished(workflow.workflow_execution_id)) {
             val res = "Response: finished"
             println(new DateTime().toString() + " " + res)
             Future(Redirect(routes.CheckIfFinishedController.index).flashing("success" -> res))
             Future(Ok(Json.toJson(res)))
          } else {
             val res = "Response: not finished"
             println(new DateTime().toString() + " " + res)
             Future(Redirect(routes.CheckIfFinishedController.index).flashing("success" -> res))
             Future(Ok(Json.toJson(res)))
          }
        } else {
          val res = "Error: incorrect workflow execution id"
          println(new DateTime().toString() + " " + res)
          Future(Redirect(routes.CheckIfFinishedController.index).flashing("success" -> res))
          Future(Ok(Json.toJson(res)))
        }
      }
    )
  }
}


case class CheckIfFinishedForm(workflow_execution_id: Int)
