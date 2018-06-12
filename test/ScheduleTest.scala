import controllers.TriggerInitialization
import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test._

import scala.concurrent.Await
import scala.concurrent.duration._

@RunWith(classOf[JUnitRunner])
class ScheduleTest extends Specification {

  "Application" should {

    "Test Initialization trait" in new WithApplication {
      val testController = new TriggerInitialization(){val scheduleRepository = scheduleRepository}
      Await.result(testController.initialize("{sdsadsadsa}", "dsadsafqwwq"), 3 seconds) mustEqual(Unit)
    }
  }
}
