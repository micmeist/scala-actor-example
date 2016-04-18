package exceptionExample

import akka.actor.SupervisorStrategy.{Resume, Restart, Stop, Escalate}
import akka.actor.{OneForOneStrategy, Actor, Props}
import scala.concurrent.duration._

/**
  * Created by Michael Meister on 09.04.2016.
  */
class ParentActor extends Actor {

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
    case _: ArithmeticException => Resume
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }

  val almightyChild = context.actorOf(Props[AlmightyChildActor], "almightyChild")

  override def receive = {
    case DangerousMessage => almightyChild ! DangerousMessage
  }

}

class AlmightyChildActor extends Actor {

  override def receive = {
    case DangerousMessage => println("I do something dangerous")
  }

}
