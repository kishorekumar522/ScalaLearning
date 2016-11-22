package com.ykk.basic

/**
  * Created by kishoreyakkala on 04/11/16.
  */
object KShiftsArray extends App{

  var arr = Array(1,2,3,4,5,6)
  val sft = 2
  val lng = arr.length

  Option
  positionShifts(arr)(sft).foreach{print}
  println
  arr.takeRight(lng-sft) ++ arr.take(sft) foreach(print)
  println
  arr :+ 7 foreach(print)

  def positionShifts(arr : Array[Int])(p:Int)={
    var temp = arr.toBuffer

    (1 to p).foreach(i => {
      temp = temp.tail.:+(temp.head)
    })
    temp
  }
}
