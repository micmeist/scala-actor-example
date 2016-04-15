package pingPong

import akka.actor.Actor

/**
  * Created by Michael Meister on 15.04.2016.
  */
class Ping(private val playerName: String) extends Actor {

  private var count: Int = 0

  private def countAndPing(gameID: String) = {
    count -= 1
    println(playerName + " makes Ping")
  }

  override def receive: Receive = {
    case message: StartMessage =>
      println("Start Game " + message.gameID)
      count = message.count
      countAndPing(message.gameID)
      message.other ! PingMessage(message.gameID)

    case message: PongMessage =>
      if (count > 0) {
        countAndPing(message.gameID)
        sender ! PingMessage(message.gameID)
      } else {
        println("Game " + message.gameID + " end")
      }
  }
}

class Pong extends Actor {

  override def receive: Receive = {
    case message: PingMessage =>
      println(message.gameID + " Robo makes Pong")
      sender ! PongMessage(message.gameID)
  }
}