package bankExample

import akka.actor.ActorRef

/**
  * Created by Michael Meister on 15.04.2016.
  */
case class Transaction (amount: Int, account: ActorRef)
case class TransactionFailed (account: ActorRef)

case class MinusTransaction (amount: Int)
case class PlusTransaction (amount: Int)
