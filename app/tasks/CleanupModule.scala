package tasks


import models.{WorkflowRepository, WorkflowExecutionRepository}
import javax.inject.{Singleton, Inject}

import akka.actor.ActorSystem
import com.google.inject.AbstractModule

import play.api.inject.ApplicationLifecycle

// https://www.playframework.com/documentation/2.4.x/ThreadPools
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.Future
import scala.concurrent.duration._

class CleanupModule extends AbstractModule {
  override def configure() = {
    bind(classOf[RecurrentTask]).asEagerSingleton()
  }
}

@Singleton
class RecurrentTask @Inject() (actorSystem: ActorSystem,
                               lifecycle: ApplicationLifecycle,
                               repo: WorkflowExecutionRepository,
                               repo2: WorkflowRepository,
                              ) {

  // Scheduling the job using the injected ActorSystem
  actorSystem.scheduler.schedule(1.second, 20.second) {
    println("Cleanup job running...")
    val workflowExecutionsToClear = repo.getLastMinuteIds()
    workflowExecutionsToClear.map{ case r => for (c <- r) {
        // Check if finished
        println("Clearing WorkflowExecution id: " + c.id)
        repo.deleteWorkflowExecution(c.id)
      }
    }

    //workflowExecutionsToClear onSuccess { case x => println(x)}

    // if (Await.result(repo.returnCurrentStep(workflow.workflow_execution_id), 3 seconds) >=
    //   Await.result(repo2.getNumberOfSteps(workflow.workflow_execution_id), 3 seconds)) {
    // NEED TO REFACTOR THIS AS FUNCTION
  }

  // This is necessary to avoid thread leaks
  lifecycle.addStopHook{ () =>
    Future.successful(actorSystem.terminate())
  }

}
