package controllers

import javax.inject._
import play.api.mvc._
import scala.concurrent.ExecutionContext


class IndexController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  def index() = Action { implicit request =>
    Ok(views.html.index()) }

  }
