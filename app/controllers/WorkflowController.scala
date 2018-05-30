package controllers

import javax.inject._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class WorkflowController @Inject()(repo: WorkflowRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
   * The mapping for the person form.
   */
  val workflowForm: Form[CreateWorkflowForm] = Form {
    mapping(
      "number_of_steps" -> number.verifying(min(0), max(1024))
    )(CreateWorkflowForm.apply)(CreateWorkflowForm.unapply)
  }

  /**
   * The index action.
   */
  def index = Action { implicit request =>
    Ok(views.html.index(workflowForm))
  }

  /**
   * The add workflow action.
   *
   * This is asynchronous, since we're invoking the asynchronous methods on WorkflowRepository.
   */
  def addWorkflow = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    workflowForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(Ok(views.html.index(errorForm)))
      },
      // There were no errors in the from, so create the person.
      workflow => {
        repo.create(workflow.number_of_steps).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.WorkflowController.index).flashing("success" -> "workflow.created")
        }
      }
    )
  }

  /**
   * A REST endpoint that gets all the people as JSON.
   */
  def getWorkflows = Action.async { implicit request =>
    repo.list().map { workflows =>
      Ok(Json.toJson(workflows))
    }
  }
}

/**
 * The create person form.
 *
 * Generally for forms, you should define separate objects to your models, since forms very often need to present data
 * in a different way to your models.  In this case, it doesn't make sense to have an id parameter in the form, since
 * that is generated once it's created.
 */
case class CreateWorkflowForm(number_of_steps: Int)
