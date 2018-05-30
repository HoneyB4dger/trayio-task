// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthews/TRAY/trayio-task3/conf/routes
// @DATE:Mon May 28 19:50:19 BST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:10
  class ReverseCheckIfFinishedController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def checkIfFinished(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "checkIfFinished")
    }
  
    // @LINE:10
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "index4")
    }
  
  }

  // @LINE:23
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseWorkflowController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "index")
    }
  
    // @LINE:13
    def getWorkflows(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflows")
    }
  
    // @LINE:12
    def addWorkflow(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflow")
    }
  
  }

  // @LINE:8
  class ReverseWorkflowExecutionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def addWorkflowExecution(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflowExecution")
    }
  
    // @LINE:8
    def index2(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "index2")
    }
  
    // @LINE:16
    def getWorkflowExecutions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflowExecutions")
    }
  
  }

  // @LINE:9
  class ReverseIncrementController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def increment(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "increment")
    }
  
    // @LINE:9
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "index3")
    }
  
  }


}
