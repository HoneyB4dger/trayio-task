package controllers

import javax.inject._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

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
        if (Await.result(repo.getCurrentStep(workflow.workflow_execution_id), 3 seconds) >=
          Await.result(repo2.getNumberOfSteps(workflow.workflow_execution_id), 3 seconds)) {
           Future(Redirect(routes.IncrementController.index).flashing("success" -> "workflow.alreadyMax"))
        } else {
          repo.increment(workflow.workflow_execution_id).map { _ =>
            Redirect(routes.IncrementController.index).flashing("success" -> "workflow.incremented")
          }
        }
      }
    )
  }

}

case class IncrementForm(workflow_execution_id: Int)
