package main

import akka.http.scaladsl.server.{HttpApp, Route}
import http._

object Application extends HttpApp with App {
  lazy val endpoints: Endpoint = new Endpoint()

  override protected def routes: Route = endpoints.routes

  startServer("0.0.0.0", 5000)
}
