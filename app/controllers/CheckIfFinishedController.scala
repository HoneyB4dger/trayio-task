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
        if (Await.result(repo.getCurrentStep(workflow.workflow_execution_id), 3 seconds) >=
          Await.result(repo2.getNumberOfSteps(workflow.workflow_execution_id), 3 seconds)) {
           Future(Redirect(routes.CheckIfFinishedController.index).flashing("success" -> "workflow.Finished"))
        } else {
           Future(Redirect(routes.CheckIfFinishedController.index).flashing("success" -> "workflow.NotFinished"))
        }
      }
    )
  }

}

case class CheckIfFinishedForm(workflow_execution_id: Int)
