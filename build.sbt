name := "potential-octo-broccoli"

version := "1"

scalaVersion := "2.12.8"

resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/eed3si9n/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)

enablePlugins(JavaAppPackaging)

test in assembly := {}

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "com.typesafe.akka"      %% "akka-actor"               % "2.6.13",
  "com.typesafe.akka"      %% "akka-stream"              % "2.6.13",
  "com.typesafe.akka"      %% "akka-http"                % "10.2.4",
  "io.circe"               %% "circe-core"               % "0.13.0",
  "io.circe"               %% "circe-generic"            % "0.13.0",
  "io.circe"               %% "circe-generic-extras"     % "0.13.0",
  "io.circe"               %% "circe-parser"             % "0.13.0",
  "io.circe"               %% "circe-optics"             % "0.13.0",
  "org.scalactic"          %% "scalactic"                % "3.2.5",
  "org.scalatest"          %% "scalatest"                % "3.2.5" % Test,
  "org.scalatestplus"      %% "mockito-3-4"              % "3.2.5.0" % Test,
  "com.typesafe.akka"      %% "akka-http-testkit"        % "10.2.4" % Test,
  "com.typesafe.akka"      %% "akka-stream-testkit"      % "2.6.13" % Test
)
