name := """trayio-task"""

version := "2.6.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"

libraryDependencies += "com.h2database" % "h2" % "1.4.196"

libraryDependencies += "joda-time" % "joda-time" % "2.9.9"

libraryDependencies += specs2 % Test



// TODO:
/*
 > default port
 > swagger front end
 > error handlings
 > check if workflow exist when creating execution
 > check if increment execution exist
 > cleanup - is it not better to check for steps which are same as workflow max steps?
 > cleanup the project
 > understand the asynchronous
 > change version number
 > testing with python script
 > nginx/apache server
 > number of threads https://stackoverflow.com/questions/22535826/play-framework-async-processing-and-blocking-i-o-in-java?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
 > Lagom
 > how to connect to DB
 > use trayio-task2 to get index format
 > play tests?
 */
