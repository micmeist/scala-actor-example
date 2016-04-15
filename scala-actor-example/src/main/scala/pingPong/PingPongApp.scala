package pingPong

import akka.actor.{Props, ActorSystem}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object PingPongApp extends App {

  val system = ActorSystem("PingPongActorSystem")
  val PingAlfred = system.actorOf(Props(new Ping("Alfred")), "PingActor1")
  val PingBernd = system.actorOf(Props(new Ping("Bernd")), "PingActor2")
  val pong = system.actorOf(Props[Pong], "PongActor")

  println("Start Games")
  PingAlfred ! StartMessage(10, "A", pong)
  PingBernd ! StartMessage(10, "B", pong)
  println("Games started")
}
