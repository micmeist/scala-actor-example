package pathExample

import akka.actor.{ActorSystem, Props}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object PathExampleApp extends App {
  
  val system = ActorSystem("ActorSystem")
  val actor = system.actorOf(Props[ParentActor], "Parent")

  actor ! HelloMessage("Hello by ActorRef of Parent")
  system.actorSelection("akka://ActorSystem/user/Parent/child0") ! HelloMessage("Hello by direct selection of child")

}
