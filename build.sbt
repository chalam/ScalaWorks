name := "ScalaWorks"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "junit" % "junit" % "4.11" % "test"
)

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.3" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT"


