package http

import akka.actor.testkit.typed.scaladsl.ActorTestKit
import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers

class EndpointTest extends AnyFeatureSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  lazy val testKit: ActorTestKit = ActorTestKit()
  implicit def typedSystem: ActorSystem[Nothing] = testKit.system

  lazy val routes: Route = new Endpoint().routes

  Feature("Hello world endpoint") {
    Scenario("get") {
      Get("/") ~> routes ~> check {}
    }
  }
}
