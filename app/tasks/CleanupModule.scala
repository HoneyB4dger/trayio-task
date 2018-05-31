package tasks


import models.{WorkflowRepository, WorkflowExecutionRepository}
import javax.inject.{Singleton, Inject}

import akka.actor.ActorSystem
import com.google.inject.AbstractModule
import org.joda.time.DateTime

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
  actorSystem.scheduler.schedule(1.second, 60.second) {
    println(new DateTime().toString() + " Cleanup job running...")
    val workflowExecutionsToClear = repo.getOldIds()
    workflowExecutionsToClear.map{ case r => for (c <- r) {
        val currentId = c.id
        //println(currentId)
        if (repo.checkDbIfFinished(currentId)) {
          println(new DateTime().toString() + " Clearing WorkflowExecution id: " + currentId)
          repo.deleteWorkflowExecution(currentId)
        }
      }
    }
  }

  // This is necessary to avoid thread leaks
  lifecycle.addStopHook{ () =>
    Future.successful(actorSystem.terminate())
  }

}
