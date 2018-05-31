package controllers

import javax.inject._

import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._
import java.util.Date
import org.joda.time.DateTime
import models._

import scala.concurrent.{ Future, ExecutionContext, Await }
import scala.concurrent.duration._

class WorkflowExecutionController @Inject()(repo: WorkflowExecutionRepository,
                                  repo2: WorkflowRepository,
                                  repoWorkflows: WorkflowRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val workflowExecutionForm: Form[CreateWorkflowExecutionForm] = Form {
    mapping(
        "workflow_id" -> number.verifying(min(0)),
        //"current_step_index" -> number.verifying(min(0), max(1024)),
        //"creation_timestamp" -> nonEmptyText
    )(CreateWorkflowExecutionForm.apply)(CreateWorkflowExecutionForm.unapply)
  }

  def index = Action { implicit request =>
    Ok(views.html.workflowExecution(workflowExecutionForm))
  }


  def addWorkflowExecution = Action.async { implicit request =>
    workflowExecutionForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok(views.html.workflowExecution(errorForm)))
      },
      workflowExecution => {
        val now = new java.sql.Timestamp(new java.util.Date().getTime).toString();
        if (repo2.workflowExist(workflowExecution.workflow_id)) {
          repo.create(workflowExecution.workflow_id, 0, now).map { _ =>
            val res = "Response: workflow execution created"
            println(new DateTime().toString() + " " + res)
            Redirect(routes.WorkflowExecutionController.index).flashing("success" -> res)
            Ok(Json.toJson(res))}
        } else {
            val res = "Error: incorrect workflow id"
            println(new DateTime().toString() + " " + res)
            Future(Redirect(routes.WorkflowExecutionController.index).flashing("success" -> res))
            Future(Ok(Json.toJson(res)))
          }
      }
    )
  }

  def getWorkflowExecutions = Action.async { implicit request =>
    repo.list().map { workflowExecutions =>
      Ok(Json.toJson(workflowExecutions))
    }
  }

}

case class CreateWorkflowExecutionForm(workflow_id: Int)
