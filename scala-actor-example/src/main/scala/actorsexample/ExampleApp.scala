package actorsexample

import akka.actor.{Props, ActorSystem}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object ExampleApp extends App {


  val system = ActorSystem("ExampleActorSystem")
  val actor = system.actorOf(Props[ExampleActor], "ExampleActorA")

  actor ! "Hello World"

}
