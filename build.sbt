organization := "ch.acmesoftware"

name := "fj-scala-conversions"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

scalacOptions in Compile ++= Seq(
  "-encoding", "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlog-reflective-calls",
  "-Xlint"
)

libraryDependencies ++= Seq(
  "org.functionaljava" % "functionaljava" % "4.6",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  "org.scalactic" %% "scalactic" % "3.0.1" % Test
)

lazy val root = (project in file("."))


