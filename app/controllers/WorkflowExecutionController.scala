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
import models._

import scala.concurrent.{ExecutionContext, Future}

class WorkflowExecutionController @Inject()(repo: WorkflowExecutionRepository,
                                  repoWorkflows: WorkflowRepository,
                                  cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  val workflowExecutionForm: Form[CreateWorkflowExecutionForm] = Form {
    mapping(
        "workflow_id" -> number.verifying(min(0), max(1024)),
        //"current_step_index" -> number.verifying(min(0), max(1024)),
        //"creation_timestamp" -> nonEmptyText
    )(CreateWorkflowExecutionForm.apply)(CreateWorkflowExecutionForm.unapply)
  }

  def index2 = Action { implicit request =>
    Ok(views.html.index2(workflowExecutionForm))
  }

  def workflowExist(workflow_id: Long) = {
    var found = false;
    repoWorkflows.list().map { future => {
          future.map { w => {
              if (w.id == workflow_id) true;
              //println(w.id)
              // TODO TODO TODO FIX THIS
            }
          }
        }
    }
  }
  //def exists(id : Int, name : String) : Future[Boolean] =
  //    db.run(User.filter(i => i.id === id || i.name === name).exists.result)

  def addWorkflowExecution = Action.async { implicit request =>
    workflowExecutionForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(Ok(views.html.index2(errorForm)))
      },
      workflowExecution => {
        val now = new java.sql.Timestamp(new java.util.Date().getTime).toString();
        //println(workflowExist(workflowExecution.workflow_id))
        //println("-"*70)
        repo.create(workflowExecution.workflow_id, 0, now).map { _ =>
          Redirect(routes.WorkflowExecutionController.index2).flashing("success" -> "workflowExecution.created")
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
