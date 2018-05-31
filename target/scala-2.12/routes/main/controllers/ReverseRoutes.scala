// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/conf/routes
// @DATE:Wed May 30 21:26:32 BST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:5
  class ReverseCheckIfFinishedController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def checkIfFinished(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "checkIfFinished")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "checkiffinished")
    }
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:2
  class ReverseWorkflowController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflow")
    }
  
    // @LINE:8
    def getWorkflows(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflows")
    }
  
    // @LINE:7
    def addWorkflow(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflow")
    }
  
  }

  // @LINE:3
  class ReverseWorkflowExecutionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addWorkflowExecution(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "workflowExecution")
    }
  
    // @LINE:3
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflowExecution")
    }
  
    // @LINE:11
    def getWorkflowExecutions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "workflowExecutions")
    }
  
  }

  // @LINE:1
  class ReverseIndexController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:4
  class ReverseIncrementController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def increment(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "increment")
    }
  
    // @LINE:4
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "increment")
    }
  
  }


}
