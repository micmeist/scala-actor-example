package pingPong

import akka.actor.Actor

/**
  * Created by Michael Meister on 15.04.2016.
  */
class Ping(private val playerName: String) extends Actor {

  private var count: Int = 0

  private def pingAndCount = {
    println(playerName + " makes Ping " + count)
    count -= 1
  }

  override def receive: Receive = {
    case startMessage: StartMessage =>
      println(playerName + " starts game")
      count = startMessage.count
      pingAndCount
      startMessage.other ! PingMessage(playerName)

    case PongMessage =>
      if (count > 0) {
        pingAndCount
        sender ! PingMessage(playerName)
      } else {
        println(playerName + " finished game")
      }
  }
}

class Pong extends Actor {

  override def receive: Receive = {
    case pingMessage: PingMessage =>
      println("Robo makes Pong to " + pingMessage.playerName)
      sender ! PongMessage
  }
}