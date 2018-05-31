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

class IncrementController @Inject()(repo: WorkflowExecutionRepository,
                                    repo2: WorkflowRepository,
                                    cc: MessagesControllerComponents
                                    )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val incrementForm: Form[IncrementForm] = Form {
    mapping(
      "workflow_execution_id" -> number.verifying(min(0), max(1024))
    )(IncrementForm.apply)(IncrementForm.unapply)
  }

  def index = Action { implicit request =>
    Ok(views.html.increment(incrementForm))
  }

  def increment = Action.async { implicit request =>
    incrementForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok(views.html.increment(errorForm)))
      },
      workflow => {
        if (repo.workflowExecutionExist(workflow.workflow_execution_id)) {
          if (repo.checkDbIfFinished(workflow.workflow_execution_id)) {
             val res = "Error: already finished"
             println(new DateTime().toString() + " " + res)
             Future(Redirect(routes.IncrementController.index).flashing("success" -> res))
             Future(Ok(Json.toJson(res)))
          } else {
            repo.increment(workflow.workflow_execution_id).map { _ =>
              val res = "Response: workflow execution step index incremented"
              println(new DateTime().toString() + " " + res)
              Redirect(routes.IncrementController.index).flashing("success" -> res)
              Ok(Json.toJson(res))}}
        } else {
          val res = "Error: incorrect workflow execution id"
          println(new DateTime().toString() + " " + res)
          Future(Redirect(routes.IncrementController.index).flashing("success" -> res))
          Future(Ok(Json.toJson(res)))
        }
      }
    )
  }

}

case class IncrementForm(workflow_execution_id: Int)
