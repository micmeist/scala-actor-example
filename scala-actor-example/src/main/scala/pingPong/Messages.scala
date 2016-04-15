package pingPong

import akka.actor.ActorRef

/**
  * Created by Michael Meister on 15.04.2016.
  */
case class PingMessage(playerName: String)

case object PongMessage

case class StartMessage(count: Int, other : ActorRef)