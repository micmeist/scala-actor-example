package pingPong

import akka.actor.{Props, ActorSystem}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object PingPongApp extends App {

  val system = ActorSystem("PingPongActorSystem")
  val pingA = system.actorOf(Props(new Ping("A")), "PingActorA")
  val pingB = system.actorOf(Props(new Ping("B")), "PingActorB")
  val pong = system.actorOf(Props[Pong], "PongActor")

  println("Start Games")
  pingA ! StartMessage(10, pong)
  pingB ! StartMessage(20, pong)
  println("Games started")
}
