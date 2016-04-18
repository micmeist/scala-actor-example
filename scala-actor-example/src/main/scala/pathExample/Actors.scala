package pathExample

import akka.actor.{Actor, Props}

/**
  * Created by Michael Meister on 09.04.2016.
  */
class ParentActor extends Actor {

  val child = context.actorOf(Props[HelloChildActor], "child0")

  override def receive = {
    case hm: HelloMessage =>
      context.actorSelection("child0") ! HelloMessage(hm.message)
  }

}

class HelloChildActor extends Actor {

  override def receive = {
    case hm: HelloMessage => println(s"You said: ${hm.message}")
  }

}