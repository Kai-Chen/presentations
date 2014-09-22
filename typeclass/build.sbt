name := "typeclass-presentation-01"

scalaVersion := "2.10.4"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.6" withSources()

initialCommands := "import scalaz._, Scalaz._; import com.sorrentocorp.presentation.typeclass.PuttingItTogether._"
