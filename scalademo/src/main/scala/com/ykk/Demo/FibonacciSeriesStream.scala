package com.ykk.Demo

/**
  * Created by kishoreyakkala on 20/09/16.
  */
object FibonacciSeriesStream extends App{

  fib(0,1).take(10).foreach(println)

  def fib(a:Int, b:Int):Stream[Int] = a #:: fib(b, a+b)

}
