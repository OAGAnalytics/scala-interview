import sbt.Keys._

val commonSettings = Seq(
  scalaVersion := "2.12.4",
  organization := "com.oag",
  crossPaths := false,
  publishArtifact in Test := false,
  retrieveManaged := false,
  javaOptions += "-Xmx2G",
  fork := true,

  parallelExecution in Test := false,

  javaOptions in Test += "-Dlogback.configurationFile=test/resources/logback.xml",

  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  
  scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-language:implicitConversions",
    "-deprecation",
    "-encoding", "utf-8",
    "-explaintypes",
    "-feature",
    "-unchecked"
  )
)

val OpenCsvVersion = "4.0"
val ArmVersion = "2.0"

// test
val scalaTestVersion = "3.0.4"

val libs = Seq(
  "com.opencsv" % "opencsv" % OpenCsvVersion,
  "com.jsuereth" %% "scala-arm" % ArmVersion
)

val testLibs = Seq (
  "org.scalatest" %% "scalatest" % scalaTestVersion
).map(_ % Test)

lazy val root = (project in file(".")).settings(
  //Make the common settings global to the build
  inThisBuild(commonSettings),

  name := "oag-interview",

  libraryDependencies ++= libs ++
                          testLibs
)
