package exceptionExample

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._



/**
  * Created by Michael Meister on 09.04.2016.
  */
class ParentActor extends Actor {

  override val supervisorStrategy =
    OneForOneStrategy(loggingEnabled = false) {
    case _: ArithmeticException => Resume
    case _: NullPointerException =>
      println("Nullpointer!")
      Restart
    case _: IllegalArgumentException => Stop
    case _: Exception => Escalate
  }

  implicit val timeout = Timeout(5 seconds)
  val almightyChild = context.actorOf(Props[AlmightyChildActor], "almightyChild")

  override def receive = {
    case _ =>
    (almightyChild ? (DangerousMessage)).onComplete{
      case _ => print("OK")
    }
  }

}

class AlmightyChildActor extends Actor {

  override def receive = {
    case DangerousMessage => println("I do something dangerous")
      throw new NullPointerException
  }

}
