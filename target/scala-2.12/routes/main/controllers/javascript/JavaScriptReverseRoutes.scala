// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthews/TRAY/trayio-task3/conf/routes
// @DATE:Mon May 28 19:50:19 BST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:10
  class ReverseCheckIfFinishedController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def checkIfFinished: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CheckIfFinishedController.checkIfFinished",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "checkIfFinished"})
        }
      """
    )
  
    // @LINE:10
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CheckIfFinishedController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index4"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseWorkflowController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index"})
        }
      """
    )
  
    // @LINE:13
    def getWorkflows: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.getWorkflows",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows"})
        }
      """
    )
  
    // @LINE:12
    def addWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.addWorkflow",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseWorkflowExecutionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def addWorkflowExecution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.addWorkflowExecution",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflowExecution"})
        }
      """
    )
  
    // @LINE:8
    def index2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.index2",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index2"})
        }
      """
    )
  
    // @LINE:16
    def getWorkflowExecutions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.getWorkflowExecutions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflowExecutions"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseIncrementController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def increment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IncrementController.increment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "increment"})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IncrementController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index3"})
        }
      """
    )
  
  }


}
