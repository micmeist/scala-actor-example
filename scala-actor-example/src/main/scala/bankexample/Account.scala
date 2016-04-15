package bankExample

import akka.actor.Actor

/**
  * Created by Michael Meister on 15.04.2016.
  */
class Account extends Actor{

  var amount : Int = 0

  override def receive: Receive = {
    case transaction: MinusTransaction =>
      if(amount >= transaction.amount) {
        amount -= transaction.amount
      }else{
        sender ! TransactionFailed(self)
      }
    case transaction: PlusTransaction => amount += transaction.amount
  }
}
