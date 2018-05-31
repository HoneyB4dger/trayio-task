// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/conf/routes
// @DATE:Wed May 30 21:26:32 BST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:5
  class ReverseCheckIfFinishedController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def checkIfFinished: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CheckIfFinishedController.checkIfFinished",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "checkIfFinished"})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CheckIfFinishedController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "checkiffinished"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseWorkflowController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow"})
        }
      """
    )
  
    // @LINE:8
    def getWorkflows: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.getWorkflows",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflows"})
        }
      """
    )
  
    // @LINE:7
    def addWorkflow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowController.addWorkflow",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflow"})
        }
      """
    )
  
  }

  // @LINE:3
  class ReverseWorkflowExecutionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addWorkflowExecution: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.addWorkflowExecution",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "workflowExecution"})
        }
      """
    )
  
    // @LINE:3
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflowExecution"})
        }
      """
    )
  
    // @LINE:11
    def getWorkflowExecutions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WorkflowExecutionController.getWorkflowExecutions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "workflowExecutions"})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseIndexController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IndexController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:4
  class ReverseIncrementController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def increment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IncrementController.increment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "increment"})
        }
      """
    )
  
    // @LINE:4
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IncrementController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "increment"})
        }
      """
    )
  
  }


}
