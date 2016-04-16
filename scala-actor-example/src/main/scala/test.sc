import akka.actor.{Actor, ActorSystem, Props}

class ExampleActor(private val name: String) extends Actor {

  override def receive = {
    case message: String => println(s"You said: $message")
    case _ => println("What?")
  }

}

object ExampleApp extends App {

  val system = ActorSystem("ExampleActorSystem")
  val actor = system.actorOf(Props(classOf[ExampleActor], "Max"), "MaxTheExampleActor")

  actor ! "Hello World"

}