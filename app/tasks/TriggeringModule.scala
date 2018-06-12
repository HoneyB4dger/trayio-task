package tasks


import akka.actor.ActorSystem
import com.google.inject.AbstractModule
import controllers.WorkflowTriggering
import javax.inject.{Inject, Singleton}
import models.ScheduleRepository
import org.joda.time.DateTime
import play.api.inject.ApplicationLifecycle

// https://www.playframework.com/documentation/2.4.x/ThreadPools
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future
import scala.concurrent.duration._

class TriggeringModule extends AbstractModule {
  override def configure() = {
    bind(classOf[TriggerTask]).asEagerSingleton()
  }
}

@Singleton
class TriggerTask @Inject() (actorSystem: ActorSystem,
                               lifecycle: ApplicationLifecycle,
                               repo: ScheduleRepository) {

  // Scheduling the job using the injected ActorSystem
  actorSystem.scheduler.schedule(30.second, 30.second) {
    println(new DateTime().toString() + " Running a schedule check...")

    val schedulesToExecute = repo.getIdsToExecute()
    schedulesToExecute.map{ case r => for (c <- r) {
      val currentId = c.id
      val workflowUuid = c.workflowUuid
      val wt = new WorkflowTriggering;
      println(new DateTime().toString() + " Attemting to run an schedule id " + currentId)
      println(wt.invokeScheduledTrigger(workflowUuid))
      repo.updateTimestamps(workflowUuid)
    }
    }
  }

  // This is necessary to avoid thread leaks
  lifecycle.addStopHook{ () =>
    Future.successful(actorSystem.terminate())
  }

}
