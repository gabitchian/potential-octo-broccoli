package http

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.actor.typed.ActorSystem

class Endpoint(implicit system: ActorSystem[_]) {

  private def helloWorldRoute: Route = get {
    system.log.info("default route accessed")
    complete(StatusCodes.OK, { """message: Hello World!""" })
  }

  def routes: Route = helloWorldRoute

}
