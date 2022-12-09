val Scala3 = "3.2.1"

val s4sLibVersion = "0.1.1"
val s4sAppVersion = "0.1.1"

ThisBuild / scalaVersion := Scala3
ThisBuild / githubWorkflowTargetBranches := Seq("main")

lazy val root = project
  .in(file("."))
  .aggregate(app)

lazy val app = project
  .enablePlugins(Smithy4sCodegenPlugin)
  .in(file("app"))
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.4.2",
      "com.disneystreaming.smithy4s" %% "smithy4s-core" % smithy4sVersion.value,
      "io.github.ahjohannessen" %% "s4s-lib" % s4sLibVersion,
      "io.github.ahjohannessen" % "s4s-app" % s4sAppVersion % Smithy4s
    )

    //
    // ,
    // libraryDependencies +=
    //   ("io.github.ahjohannessen" %% "s4s-lib" % s4sLibVersion % Smithy4s)
    //     .cross(CrossVersion.Constant(scalaBinaryVersion.value))
    //
    // , libraryDependencies +=
    //   "io.github.ahjohannessen" % "s4s-lib-specs" % s4sLibVersion % Smithy4s

  )
