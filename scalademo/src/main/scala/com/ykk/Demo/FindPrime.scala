package com.ykk.Demo

/**
  * Created by kishoreyakkala on 31/08/16.
  */
object FindPrime extends App{

  val n = 100

  (2 to n).filterNot{d => (2 to d-1).exists(d%_==0)}.foreach(println)
}
