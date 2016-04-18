package exceptionExample

import akka.actor.{ActorSystem, Props}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object HierarchyExampleApp extends App {
  
  val system = ActorSystem("ExceptionActorSystem")
  val actor = system.actorOf(Props[ParentActor], "Parent")

  actor ! DangerousMessage

}
