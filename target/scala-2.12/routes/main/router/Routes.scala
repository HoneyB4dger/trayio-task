// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthews/TRAY/trayio-task3/conf/routes
// @DATE:Mon May 28 19:50:19 BST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  WorkflowController_4: controllers.WorkflowController,
  // @LINE:8
  WorkflowExecutionController_1: controllers.WorkflowExecutionController,
  // @LINE:9
  IncrementController_2: controllers.IncrementController,
  // @LINE:10
  CheckIfFinishedController_0: controllers.CheckIfFinishedController,
  // @LINE:23
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    WorkflowController_4: controllers.WorkflowController,
    // @LINE:8
    WorkflowExecutionController_1: controllers.WorkflowExecutionController,
    // @LINE:9
    IncrementController_2: controllers.IncrementController,
    // @LINE:10
    CheckIfFinishedController_0: controllers.CheckIfFinishedController,
    // @LINE:23
    Assets_3: controllers.Assets
  ) = this(errorHandler, WorkflowController_4, WorkflowExecutionController_1, IncrementController_2, CheckIfFinishedController_0, Assets_3, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, WorkflowController_4, WorkflowExecutionController_1, IncrementController_2, CheckIfFinishedController_0, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index""", """controllers.WorkflowController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index2""", """controllers.WorkflowExecutionController.index2"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index3""", """controllers.IncrementController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index4""", """controllers.CheckIfFinishedController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflow""", """controllers.WorkflowController.addWorkflow"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflows""", """controllers.WorkflowController.getWorkflows"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflowExecution""", """controllers.WorkflowExecutionController.addWorkflowExecution"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflowExecutions""", """controllers.WorkflowExecutionController.getWorkflowExecutions"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """increment""", """controllers.IncrementController.increment"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkIfFinished""", """controllers.CheckIfFinishedController.checkIfFinished"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_WorkflowController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index")))
  )
  private[this] lazy val controllers_WorkflowController_index0_invoker = createInvoker(
    WorkflowController_4.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowController",
      "index",
      Nil,
      "GET",
      this.prefix + """index""",
      """ Home page
 GET     /index                              controllers.WorkflowController.index""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_WorkflowExecutionController_index21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index2")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_index21_invoker = createInvoker(
    WorkflowExecutionController_1.index2,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowExecutionController",
      "index2",
      Nil,
      "GET",
      this.prefix + """index2""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_IncrementController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index3")))
  )
  private[this] lazy val controllers_IncrementController_index2_invoker = createInvoker(
    IncrementController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IncrementController",
      "index",
      Nil,
      "GET",
      this.prefix + """index3""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_CheckIfFinishedController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index4")))
  )
  private[this] lazy val controllers_CheckIfFinishedController_index3_invoker = createInvoker(
    CheckIfFinishedController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CheckIfFinishedController",
      "index",
      Nil,
      "GET",
      this.prefix + """index4""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_WorkflowController_addWorkflow4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflow")))
  )
  private[this] lazy val controllers_WorkflowController_addWorkflow4_invoker = createInvoker(
    WorkflowController_4.addWorkflow,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowController",
      "addWorkflow",
      Nil,
      "POST",
      this.prefix + """workflow""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_WorkflowController_getWorkflows5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows")))
  )
  private[this] lazy val controllers_WorkflowController_getWorkflows5_invoker = createInvoker(
    WorkflowController_4.getWorkflows,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowController",
      "getWorkflows",
      Nil,
      "GET",
      this.prefix + """workflows""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_WorkflowExecutionController_addWorkflowExecution6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflowExecution")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_addWorkflowExecution6_invoker = createInvoker(
    WorkflowExecutionController_1.addWorkflowExecution,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowExecutionController",
      "addWorkflowExecution",
      Nil,
      "POST",
      this.prefix + """workflowExecution""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_WorkflowExecutionController_getWorkflowExecutions7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflowExecutions")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_getWorkflowExecutions7_invoker = createInvoker(
    WorkflowExecutionController_1.getWorkflowExecutions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowExecutionController",
      "getWorkflowExecutions",
      Nil,
      "GET",
      this.prefix + """workflowExecutions""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_IncrementController_increment8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("increment")))
  )
  private[this] lazy val controllers_IncrementController_increment8_invoker = createInvoker(
    IncrementController_2.increment,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IncrementController",
      "increment",
      Nil,
      "POST",
      this.prefix + """increment""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CheckIfFinishedController_checkIfFinished9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkIfFinished")))
  )
  private[this] lazy val controllers_CheckIfFinishedController_checkIfFinished9_invoker = createInvoker(
    CheckIfFinishedController_0.checkIfFinished,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CheckIfFinishedController",
      "checkIfFinished",
      Nil,
      "GET",
      this.prefix + """checkIfFinished""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_WorkflowController_index0_route(params@_) =>
      call { 
        controllers_WorkflowController_index0_invoker.call(WorkflowController_4.index)
      }
  
    // @LINE:8
    case controllers_WorkflowExecutionController_index21_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_index21_invoker.call(WorkflowExecutionController_1.index2)
      }
  
    // @LINE:9
    case controllers_IncrementController_index2_route(params@_) =>
      call { 
        controllers_IncrementController_index2_invoker.call(IncrementController_2.index)
      }
  
    // @LINE:10
    case controllers_CheckIfFinishedController_index3_route(params@_) =>
      call { 
        controllers_CheckIfFinishedController_index3_invoker.call(CheckIfFinishedController_0.index)
      }
  
    // @LINE:12
    case controllers_WorkflowController_addWorkflow4_route(params@_) =>
      call { 
        controllers_WorkflowController_addWorkflow4_invoker.call(WorkflowController_4.addWorkflow)
      }
  
    // @LINE:13
    case controllers_WorkflowController_getWorkflows5_route(params@_) =>
      call { 
        controllers_WorkflowController_getWorkflows5_invoker.call(WorkflowController_4.getWorkflows)
      }
  
    // @LINE:15
    case controllers_WorkflowExecutionController_addWorkflowExecution6_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_addWorkflowExecution6_invoker.call(WorkflowExecutionController_1.addWorkflowExecution)
      }
  
    // @LINE:16
    case controllers_WorkflowExecutionController_getWorkflowExecutions7_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_getWorkflowExecutions7_invoker.call(WorkflowExecutionController_1.getWorkflowExecutions)
      }
  
    // @LINE:18
    case controllers_IncrementController_increment8_route(params@_) =>
      call { 
        controllers_IncrementController_increment8_invoker.call(IncrementController_2.increment)
      }
  
    // @LINE:19
    case controllers_CheckIfFinishedController_checkIfFinished9_route(params@_) =>
      call { 
        controllers_CheckIfFinishedController_checkIfFinished9_invoker.call(CheckIfFinishedController_0.checkIfFinished)
      }
  
    // @LINE:23
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_3.versioned(path, file))
      }
  }
}
