package com.ykk.Demo

import scala.util.{Failure, Success, Try}

/**
  * Created by kishoreyakkala on 29/11/16.
  */
object TryFlatMap {

  def main(args: Array[String]) {
    val l = List("1","2","3", "abc")

    val result = l.map(e => Try{e.toInt})

    result.foreach(_ match{
      case Success(x) => println(x)
      case Failure(x) => println(x.getMessage)
    })

    result.filter(_.isSuccess).foreach(e => println(e.get))
  }

}
