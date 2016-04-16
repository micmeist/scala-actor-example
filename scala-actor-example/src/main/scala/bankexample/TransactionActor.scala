package bankExample

import akka.actor.Actor

/**
  * Created by Michael Meister on 15.04.2016.
  */
class TransactionActor extends Actor {

  override def receive = {
    case transaction: Transaction =>
      if (transaction.amount < 0) {
        transaction.account ! MinusTransaction(transaction.amount * -1)
      } else {
        transaction.account ! PlusTransaction(transaction.amount)
      }
    case transaction: TransactionFailed =>
      print("Transaction failed")
  }
}
