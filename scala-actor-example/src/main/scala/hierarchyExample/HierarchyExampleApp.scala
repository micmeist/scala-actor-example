package hierarchyExample

import akka.actor.{ActorSystem, Props}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object HierarchyExampleApp extends App {
  
  val system = ActorSystem("HierarchyActorSystem")
  val actor = system.actorOf(Props[ParentActor], "Parent")

  actor ! HelloMessage("Hello World")

}
