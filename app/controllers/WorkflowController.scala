package controllers

import javax.inject._
import models._
import org.joda.time.DateTime
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class WorkflowController @Inject()(repo: WorkflowRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  /**
   * The mapping for the workflow form.
   */
  val workflowForm: Form[CreateWorkflowForm] = Form {
    mapping(
      "number_of_steps" -> number.verifying(min(1), max(1024))
    )(CreateWorkflowForm.apply)(CreateWorkflowForm.unapply)
  }

  /**
   * The index action.
   */
  def index = Action { implicit request =>
    Ok(views.html.workflow(workflowForm))
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
      // a future because the workflow creation function returns a future.
      errorForm => {
        Future.successful(Ok(views.html.workflow(errorForm)))
      },
      // There were no errors in the from, so create the workflow.
      workflow => {
        repo.create(workflow.number_of_steps).map { _ =>
          // If successful, we simply redirect to the index page.
          val res = "Response: workflow created"
          println(new DateTime().toString() + " " + res)
          Redirect(routes.WorkflowController.index).flashing("success" -> res)
          Ok(Json.toJson(res))
        }
      }
    )
  }


  def getWorkflows = Action.async { implicit request =>
    repo.list().map { workflows =>
      Ok(Json.toJson(workflows))
    }
  }

}

/**
 * The create workflow form.
 *
 * Generally for forms, you should define separate objects to your models, since forms very often need to present data
 * in a different way to your models.  In this case, it doesn't make sense to have an id parameter in the form, since
 * that is generated once it's created.
 */
case class CreateWorkflowForm(number_of_steps: Int)
