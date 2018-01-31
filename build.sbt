val monocleVersion = "1.5.0"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Scala Optics",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.4",
      "com.github.julien-truffaut"  %%  "monocle-core"    % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-generic" % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-macro"   % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-state"   % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-refined" % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-unsafe"  % "1.5.0",
      "com.github.julien-truffaut"  %%  "monocle-law"     % "1.5.0" % "test",
      "org.scalaz" %% "scalaz-core" % "7.2.18"
    )
  )
