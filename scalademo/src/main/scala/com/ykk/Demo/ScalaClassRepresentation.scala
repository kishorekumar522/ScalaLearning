package com.ykk.Demo

/**
  * Created by kishoreyakkala on 15/10/16.
  */
object ScalaClassRepresentation {

  def main(args: Array[String]) {
    val u1 = User("kishore", null)
    println(u1)
//    val u2 = User(null, null)
  }
}

case class User(name:String, orders:List[Order]){
  if(name == null) throw new NullPointerException("User name cannot be null")

  override def toString=s"User : $name has ${if(orders!=null) orders.size else 0} Orders"
}

case class Order(orderId:Int, products:List[Product])

case class Product(productId:Int, category:String)
