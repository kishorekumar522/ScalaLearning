package com.ykk.basic

/**
  * Created by kishoreyakkala on 04/11/16.
  */


// Filter a list such that, for an element at position 'i', if there is
// any element of value greater in positions 0 to 'i' then that element should be filtered.
// For example, for input List(3,6,5,8,1,2), output should be List(3,6,8). Values 5,1,2 are
// filtered because values greater than these exist in positions before their-own

object DiamondPrb extends App{

  val l1 = List(3,5,1,6,2,8)

  l1.size
  var max = l1(0)

  val t1: List[Int] = for{e<-l1
    if(e>=max)
      max = e
  }yield e

  t1.foreach(println)

}
