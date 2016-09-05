package com.ykk.Demo

/**
  * Created by kishoreyakkala on 30/08/16.
  */
object FindAnagrams extends App{

  val para = "node creation is done and later ate and had tea"
  para.split("\\s+").groupBy(_.sorted.mkString).filter(_._2.toSet.size>1)
    .foreach(kv => println(s"${kv._2.mkString(",")}"))
}
