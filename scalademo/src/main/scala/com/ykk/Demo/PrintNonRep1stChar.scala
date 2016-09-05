package com.ykk.Demo

import scala.collection.mutable

/**
  * Created by kishoreyakkala on 30/08/16.
  */
object PrintNonRep1stChar extends App{

  val str = "kishore kumar"

  val strArr = str.toList

  val lHMap = new mutable.LinkedHashMap[String, Int]()
  val v = 0
  str.map(c =>{
    lHMap.put(c.toString, lHMap.get(c.toString).getOrElse(0)+1)
  })

  println("Got non-repeated 1st Char : " + lHMap.find(_._2==1).get._1)
}
