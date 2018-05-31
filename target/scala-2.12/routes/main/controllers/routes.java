// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/conf/routes
// @DATE:Wed May 30 21:26:32 BST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseCheckIfFinishedController CheckIfFinishedController = new controllers.ReverseCheckIfFinishedController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWorkflowController WorkflowController = new controllers.ReverseWorkflowController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWorkflowExecutionController WorkflowExecutionController = new controllers.ReverseWorkflowExecutionController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseIndexController IndexController = new controllers.ReverseIndexController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseIncrementController IncrementController = new controllers.ReverseIncrementController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseCheckIfFinishedController CheckIfFinishedController = new controllers.javascript.ReverseCheckIfFinishedController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWorkflowController WorkflowController = new controllers.javascript.ReverseWorkflowController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWorkflowExecutionController WorkflowExecutionController = new controllers.javascript.ReverseWorkflowExecutionController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseIndexController IndexController = new controllers.javascript.ReverseIndexController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseIncrementController IncrementController = new controllers.javascript.ReverseIncrementController(RoutesPrefix.byNamePrefix());
  }

}
