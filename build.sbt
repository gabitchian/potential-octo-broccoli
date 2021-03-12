name := "potential-octo-broccoli"

version := "1"

scalaVersion := "2.12.8"

resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/eed3si9n/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)

enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

docker / dockerfile := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("openjdk:8-jre")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir, chown = "daemon:daemon")
  }
}

test in assembly := {}

val akkaHttpVersion = "10.2.4"
val akkaVersion = "2.6.13"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "com.typesafe.akka"      %% "akka-actor"               % akkaVersion,
  "com.typesafe.akka"      %% "akka-stream"              % akkaVersion,
  "com.typesafe.akka"      %% "akka-http"                % akkaHttpVersion,
  "com.typesafe.akka"      %% "akka-http-spray-json"     % akkaHttpVersion,
  "com.typesafe.akka"      %% "akka-actor-typed"         % akkaVersion,
  "io.circe"               %% "circe-core"               % "0.13.0",
  "io.circe"               %% "circe-generic"            % "0.13.0",
  "io.circe"               %% "circe-generic-extras"     % "0.13.0",
  "io.circe"               %% "circe-parser"             % "0.13.0",
  "io.circe"               %% "circe-optics"             % "0.13.0",
  "org.scalactic"          %% "scalactic"                % "3.2.5",
  "org.scalatest"          %% "scalatest"                % "3.2.5"          % Test,
  "org.scalatestplus"      %% "mockito-3-4"              % "3.2.5.0"        % Test,
  "com.typesafe.akka"      %% "akka-http-testkit"        % "10.2.4"         % Test,
  "com.typesafe.akka"      %% "akka-stream-testkit"      % "2.6.13"         % Test,
  "com.typesafe.akka"      %% "akka-http-testkit"        % akkaHttpVersion  % Test,
  "com.typesafe.akka"      %% "akka-actor-testkit-typed" % akkaVersion      % Test,
  "ch.qos.logback"         % "logback-classic"           % "1.2.3",
)
