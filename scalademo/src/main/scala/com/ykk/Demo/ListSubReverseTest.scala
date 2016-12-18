package com.ykk.Demo

/**
  * Created by kishoreyakkala on 12/12/16.
  */
object ListSubReverseTest {

  def main(args: Array[String]) {
    val l = List(1,2,3,4,5,6,7)
    val offSet = 4
    l.grouped(offSet).flatMap(_.reverse).foreach(print)
    println()
    l.toStream.grouped(offSet).flatMap(_.reverse).foreach(print)

  }

}
