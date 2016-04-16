package actorsexample

import akka.actor.{ActorSystem, Props}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object ExampleApp extends App {


  val system = ActorSystem("ExampleActorSystem")
  val actor = system.actorOf(Props[ExampleActor], "BlaBlaActor")

  actor ! "Hello World"
  actor.tell("Hello World", null)

}
