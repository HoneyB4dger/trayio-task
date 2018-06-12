name := """trayio-task"""

version := "2.6.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice
libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.3"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.3"

libraryDependencies += "com.h2database" % "h2" % "1.4.196"
libraryDependencies += evolutions

libraryDependencies += "joda-time" % "joda-time" % "2.9.9"

libraryDependencies += specs2 % Test


//EclipseKeys.preTasks := Seq(compile in Compile)