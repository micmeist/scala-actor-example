package actorName

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.{Success, Failure}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object ExampleApp extends App {

  val system = ActorSystem("ExampleActorSystem")
  val actor = system.actorOf(Props(classOf[ExampleActor], "Max"), "MaxTheExampleActor")
  implicit val timeout = Timeout(5 seconds)

  actor ! HelloMessage("Hello World") // Prints Hello World

  val future: Future[Any] = actor ? AskNameMessage

  future.foreach(println) // Prints Max

  future.onComplete {
    case Success(msg) => print(msg)
    case Failure(ex) => print("Something failed " + ex)
  }


}
