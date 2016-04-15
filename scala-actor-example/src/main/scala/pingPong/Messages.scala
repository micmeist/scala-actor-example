package pingPong

import akka.actor.ActorRef

/**
  * Created by Michael Meister on 15.04.2016.
  */
case class PingMessage(gameID: String)

case class PongMessage(gameID: String)

case class StartMessage(count: Int, gameID: String, other : ActorRef)

case class StopMessage(gameID: String)