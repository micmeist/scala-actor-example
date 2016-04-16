import actorsexample.ExampleActor
import akka.actor.Props

val props1 = Props[ExampleActor]
val props2 = Props(new ExampleActorWithArgs("arg")) // Not recommended
val props3 = Props(classOf[ExampleActorWithArgs], "arg")
