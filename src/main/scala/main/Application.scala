package main

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import http.Endpoint

import scala.util.{Failure, Success}

object Application extends App {

  val rootBehavior = Behaviors.setup[Nothing] { context =>
      implicit val system: ActorSystem[Nothing] = context.system
      val routes = new Endpoint().routes
      startHttpServer(routes)
      Behaviors.empty
    }
  ActorSystem[Nothing](rootBehavior, "QuizHttpServer")

  private def startHttpServer(routes: Route)(implicit system: ActorSystem[_]): Unit = {
    // Akka HTTP still needs a classic ActorSystem to start
    import system.executionContext

    val futureBinding = Http().newServerAt("0.0.0.0", 5000).bind(routes)

    futureBinding.onComplete {
      case Success(binding) =>
        val address = binding.localAddress
        system.log.info("Server online at http://{}:{}/", address.getHostString, address.getPort)
      case Failure(ex) =>
        system.log.error("Failed to bind HTTP endpoint, terminating system", ex)
        system.terminate()
    }
  }
}


