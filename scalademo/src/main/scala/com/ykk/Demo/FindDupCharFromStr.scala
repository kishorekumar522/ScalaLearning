package com.ykk.Demo

/**
  * Created by kishoreyakkala on 30/08/16.
  */
object FindDupCharFromStr extends App{

  val str = "Hello Kishore"

  println(str.toList.groupBy(_.toString).filter(_._2.size>1).map(_._1).mkString)
}
