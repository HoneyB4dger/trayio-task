// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/conf/routes
// @DATE:Wed May 30 21:26:32 BST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  IndexController_0: controllers.IndexController,
  // @LINE:2
  WorkflowController_5: controllers.WorkflowController,
  // @LINE:3
  WorkflowExecutionController_2: controllers.WorkflowExecutionController,
  // @LINE:4
  IncrementController_3: controllers.IncrementController,
  // @LINE:5
  CheckIfFinishedController_1: controllers.CheckIfFinishedController,
  // @LINE:18
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    IndexController_0: controllers.IndexController,
    // @LINE:2
    WorkflowController_5: controllers.WorkflowController,
    // @LINE:3
    WorkflowExecutionController_2: controllers.WorkflowExecutionController,
    // @LINE:4
    IncrementController_3: controllers.IncrementController,
    // @LINE:5
    CheckIfFinishedController_1: controllers.CheckIfFinishedController,
    // @LINE:18
    Assets_4: controllers.Assets
  ) = this(errorHandler, IndexController_0, WorkflowController_5, WorkflowExecutionController_2, IncrementController_3, CheckIfFinishedController_1, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, IndexController_0, WorkflowController_5, WorkflowExecutionController_2, IncrementController_3, CheckIfFinishedController_1, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.IndexController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflow""", """controllers.WorkflowController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """workflowExecution""", """controllers.WorkflowExecutionController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """increment""", """controllers.IncrementController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkiffinished""", """controllers.CheckIfFinishedController.index"""),
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


  // @LINE:1
  private[this] lazy val controllers_IndexController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_IndexController_index0_invoker = createInvoker(
    IndexController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IndexController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_WorkflowController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflow")))
  )
  private[this] lazy val controllers_WorkflowController_index1_invoker = createInvoker(
    WorkflowController_5.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowController",
      "index",
      Nil,
      "GET",
      this.prefix + """workflow""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_WorkflowExecutionController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflowExecution")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_index2_invoker = createInvoker(
    WorkflowExecutionController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WorkflowExecutionController",
      "index",
      Nil,
      "GET",
      this.prefix + """workflowExecution""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_IncrementController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("increment")))
  )
  private[this] lazy val controllers_IncrementController_index3_invoker = createInvoker(
    IncrementController_3.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.IncrementController",
      "index",
      Nil,
      "GET",
      this.prefix + """increment""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_CheckIfFinishedController_index4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkiffinished")))
  )
  private[this] lazy val controllers_CheckIfFinishedController_index4_invoker = createInvoker(
    CheckIfFinishedController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CheckIfFinishedController",
      "index",
      Nil,
      "GET",
      this.prefix + """checkiffinished""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_WorkflowController_addWorkflow5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflow")))
  )
  private[this] lazy val controllers_WorkflowController_addWorkflow5_invoker = createInvoker(
    WorkflowController_5.addWorkflow,
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

  // @LINE:8
  private[this] lazy val controllers_WorkflowController_getWorkflows6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflows")))
  )
  private[this] lazy val controllers_WorkflowController_getWorkflows6_invoker = createInvoker(
    WorkflowController_5.getWorkflows,
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

  // @LINE:10
  private[this] lazy val controllers_WorkflowExecutionController_addWorkflowExecution7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflowExecution")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_addWorkflowExecution7_invoker = createInvoker(
    WorkflowExecutionController_2.addWorkflowExecution,
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

  // @LINE:11
  private[this] lazy val controllers_WorkflowExecutionController_getWorkflowExecutions8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("workflowExecutions")))
  )
  private[this] lazy val controllers_WorkflowExecutionController_getWorkflowExecutions8_invoker = createInvoker(
    WorkflowExecutionController_2.getWorkflowExecutions,
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

  // @LINE:13
  private[this] lazy val controllers_IncrementController_increment9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("increment")))
  )
  private[this] lazy val controllers_IncrementController_increment9_invoker = createInvoker(
    IncrementController_3.increment,
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

  // @LINE:14
  private[this] lazy val controllers_CheckIfFinishedController_checkIfFinished10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkIfFinished")))
  )
  private[this] lazy val controllers_CheckIfFinishedController_checkIfFinished10_invoker = createInvoker(
    CheckIfFinishedController_1.checkIfFinished,
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

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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
  
    // @LINE:1
    case controllers_IndexController_index0_route(params@_) =>
      call { 
        controllers_IndexController_index0_invoker.call(IndexController_0.index)
      }
  
    // @LINE:2
    case controllers_WorkflowController_index1_route(params@_) =>
      call { 
        controllers_WorkflowController_index1_invoker.call(WorkflowController_5.index)
      }
  
    // @LINE:3
    case controllers_WorkflowExecutionController_index2_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_index2_invoker.call(WorkflowExecutionController_2.index)
      }
  
    // @LINE:4
    case controllers_IncrementController_index3_route(params@_) =>
      call { 
        controllers_IncrementController_index3_invoker.call(IncrementController_3.index)
      }
  
    // @LINE:5
    case controllers_CheckIfFinishedController_index4_route(params@_) =>
      call { 
        controllers_CheckIfFinishedController_index4_invoker.call(CheckIfFinishedController_1.index)
      }
  
    // @LINE:7
    case controllers_WorkflowController_addWorkflow5_route(params@_) =>
      call { 
        controllers_WorkflowController_addWorkflow5_invoker.call(WorkflowController_5.addWorkflow)
      }
  
    // @LINE:8
    case controllers_WorkflowController_getWorkflows6_route(params@_) =>
      call { 
        controllers_WorkflowController_getWorkflows6_invoker.call(WorkflowController_5.getWorkflows)
      }
  
    // @LINE:10
    case controllers_WorkflowExecutionController_addWorkflowExecution7_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_addWorkflowExecution7_invoker.call(WorkflowExecutionController_2.addWorkflowExecution)
      }
  
    // @LINE:11
    case controllers_WorkflowExecutionController_getWorkflowExecutions8_route(params@_) =>
      call { 
        controllers_WorkflowExecutionController_getWorkflowExecutions8_invoker.call(WorkflowExecutionController_2.getWorkflowExecutions)
      }
  
    // @LINE:13
    case controllers_IncrementController_increment9_route(params@_) =>
      call { 
        controllers_IncrementController_increment9_invoker.call(IncrementController_3.increment)
      }
  
    // @LINE:14
    case controllers_CheckIfFinishedController_checkIfFinished10_route(params@_) =>
      call { 
        controllers_CheckIfFinishedController_checkIfFinished10_invoker.call(CheckIfFinishedController_1.checkIfFinished)
      }
  
    // @LINE:18
    case controllers_Assets_versioned11_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
