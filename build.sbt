name := "Pi_Overview"

version := "0.1"

resolvers ++= Seq(
  "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies += "org.specs2" %% "specs2" % "2.3.7" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.3" % "test"

libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5" % "test"


scalacOptions in Test ++= Seq("-Yrangepos")

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.7.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0-SNAPSHOT")

addSbtPlugin("de.johoop" % "jacoco4sbt" % "2.1.4")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
