package hierarchyExample

import akka.actor.{Props, Actor}

/**
  * Created by Michael Meister on 09.04.2016.
  */
class ParentActor extends Actor {

  var n: Int = 0
  val almightyChild = context.actorOf(Props[AlmightyChildActor], "almightyChild")

  override def receive = {
    case hm: HelloMessage =>
      val child = context.actorOf(Props[HelloChildActor], "child" + n)
      n += 1
      child.tell(HelloMessage(hm.message), self)
    case DangerousMessage =>
      almightyChild ! DangerousMessage
  }

}

class HelloChildActor extends Actor {

  override def receive = {
    case hm: HelloMessage => println(s"You said: ${hm.message}")
      context.stop(self)
    case _ => println("What?")
      context.stop(self)
  }

}

class AlmightyChildActor extends Actor {

  override def receive = {
    case DangerousMessage => println("I do something dangerous")
    case _ => println("What?")
  }

}
