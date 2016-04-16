package actorName

import akka.actor.Actor

/**
  * Created by Michael Meister on 09.04.2016.
  */
class ExampleActor(private val name: String) extends Actor {

  override def receive = {
    case hm: HelloMessage => println(s"You said: ${hm.message}")
    case AskNameMessage => sender.tell(name, self)
    case _ => println("What?")
  }

}
