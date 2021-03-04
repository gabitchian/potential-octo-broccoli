package http

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class Endpoint {
  def helloWorldRoute: Route = get {
    complete(StatusCodes.OK, { """message: Hello World!""" })
  }

  def routes: Route = helloWorldRoute

}
