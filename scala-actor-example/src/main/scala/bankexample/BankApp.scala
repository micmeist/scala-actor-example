package bankExample

import akka.actor.{ActorSystem, Props}

/**
  * Created by Michael Meister on 15.04.2016.
  */
object BankApp extends App {

  val system = ActorSystem("BankActorSystem")
  val actor = system.actorOf(Props[TransactionActor], "BankActor")
  val account = system.actorOf(Props[Account], "AccountActor")

  actor ! Transaction(100, account)
  actor ! Transaction(-30, account)

}
