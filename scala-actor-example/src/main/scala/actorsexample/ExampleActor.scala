package actorsexample

import akka.actor.Actor

/**
  * Created by Michael Meister on 09.04.2016.
  */
class ExampleActor extends Actor {

  override def receive: Receive = {
    case message : String => print(message)
  }

}
