package http

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.headers.{BasicHttpCredentials, OAuth2BearerToken}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.{RouteTestTimeout, ScalatestRouteTest}
import akka.stream.Materializer
import io.circe.Decoder.Result
import org.scalatest.{BeforeAndAfter, FeatureSpec, Matchers}

import io.circe.Json
import io.circe.optics.JsonPath
import io.circe.optics.JsonPath._

import scala.concurrent.duration._
import scala.language.postfixOps

class EndpointTest extends FeatureSpec with BeforeAndAfter with ScalatestRouteTest with Matchers {
  lazy val endpoints: Endpoint = new Endpoint()

  protected def routes: Route = endpoints.routes

  feature("Hello world endpoint") {
    scenario("get") {
      Get("/") ~> routes ~> check {}
    }
  }
}
