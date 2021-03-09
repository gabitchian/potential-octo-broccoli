package http

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.BeforeAndAfter
import org.scalatest.featurespec.AnyFeatureSpec

import scala.language.postfixOps

class EndpointTest extends AnyFeatureSpec with BeforeAndAfter with ScalatestRouteTest {
  lazy val endpoints: Endpoint = new Endpoint()

  protected def routes: Route = endpoints.routes

  Feature("Hello world endpoint") {
    Scenario("get") {
      Get("/") ~> routes ~> check {}
    }
  }
}
