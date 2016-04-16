package actorsexample

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Michael Meister on 15.04.2016.
  */
object ExampleApp extends App {


  val system = ActorSystem("ExampleActorSystem")
  val actor = system.actorOf(Props[ExampleActor], "ExampleActorA")

  actor ! "Hello World"
  actor.tell("Hello World", null)

  implicit val timeout = Timeout(5 seconds)

  val future1: Future[Any] = actor ? "Hello?"
  val future2: Future[Any] = actor.ask("Hello?")

  future1.onComplete(n => println("Future 1 happened"))
  future2.onComplete(n => println("Future 2 happened"))

}
