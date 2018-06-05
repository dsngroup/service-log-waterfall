package controllers

import controllers.apis.LoggingExtractor
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

/**
 * LoggingExtractor test.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class LoggingExtractorSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "LoggingExtractor GET" should {

    "listing log data is valid" in {
      val extractor = new LoggingExtractor(stubControllerComponents())
      val resp = extractor.list.apply(FakeRequest(GET, "/api/log"))

      status(resp) mustBe OK
      contentType(resp) mustBe Some("application/json")
    }
  }
}
