package com.ykk.basic

/**
  * Created by kishoreyakkala on 29/09/16.
  */
object ImplicitTest extends App{


  implicit def intToLoop(n:Int) = new Looping(n)

  4 times {i=>
    println(s"$i time printing")
  }

}


class Looping(n:Int){

  def times(block:Int=>Unit):Unit=(1 to n).foreach(block(_))
}