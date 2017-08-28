val commonSettings = Seq(
  resolvers ++= List(Resolver.jcenterRepo),
  scalaVersion := "2.12.3",
  organization := "org.broadinstitute",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  homepage := Some(url("https://github.com/broadinstitute/akka-statsd")),
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% s"akka-testkit" % "2.5.3",
    "org.scalatest" %% "scalatest" % "3.0.3"
  ).map(_ % "test")
)

val `akka-statsd-core` = project
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% s"akka-actor" % "2.5.3",
      "com.typesafe.akka" %% s"akka-slf4j" % "2.5.3",
      "com.iheart" %%  "ficus" % "1.4.1"
    )
  )

val `akka-statsd` =
  project.in(file("."))
  .aggregate(`akka-statsd-core`)
  .settings(
    commonSettings,
    publish := {}
  )
