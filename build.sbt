name := "potential-octo-broccoli"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "org.scala-lang.modules"   %% "scala-parser-combinators" % "1.1.2",
  "com.typesafe.akka"        %% "akka-actor"               % "2.5.23",
  "com.typesafe.akka"        %% "akka-stream"              % "2.5.23",
  "com.typesafe.akka"        %% "akka-http"                % "10.1.8",
  "io.circe"                 %% "circe-core"               % "0.13.0",
  "io.circe"                 %% "circe-generic"            % "0.13.0",
  "io.circe"                 %% "circe-generic-extras"     % "0.13.0",
  "io.circe"                 %% "circe-parser"             % "0.13.0",
  "io.circe"                 %% "circe-optics"             % "0.13.0",
  "com.softwaremill.macwire" %% "macros"                   % "2.3.7",
  "com.softwaremill.macwire" %% "util"                     % "2.3.7",
  "org.scalatest"            %% "scalatest"                % "3.2.5" % Test,
  "com.typesafe.akka"        %% "akka-http-testkit"        % "10.2.4" % Test,
  "com.typesafe.akka"        %% "akka-stream-testkit"      % "2.6.9" % Test
)
