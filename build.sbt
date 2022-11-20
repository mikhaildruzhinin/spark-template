ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.github.mikhaildruzhinin"
ThisBuild / organizationName := "mikhaildruzhinin"
ThisBuild / assemblyMergeStrategy := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}

lazy val root = (project in file("."))
  .settings(
    name := "spark-template",
    assembly / mainClass := Some(s"${ThisBuild / organization}.Main"),
//    assembly / assemblyOutputPath := file(s"apps/${(assembly / assemblyJarName).value}"),
  )

val sparkVersion = "3.2.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion /*% "provided"*/,
  "org.apache.spark" %% "spark-sql" % sparkVersion /*% "provided"*/,
)
