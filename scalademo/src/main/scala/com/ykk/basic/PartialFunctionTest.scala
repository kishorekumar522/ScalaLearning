package com.ykk.basic

/**
  * Created by kishoreyakkala on 29/08/16.
  */
object PartialFunctionTest {

  //  Below is the site for Partial Function
  //  http://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples

//  Execution happen in Seq for variables.. so, the below step fails as divide defination doesn't exist
//  To Test it, please uncomment it
//  println("Divide Partial Function : " + divide(5))

  def main(args: Array[String]) {

    println(s"Divide Partial Function : ${divide(0)}")
    println(s"Divide Partial Function : ${divide2.lift(0)}")
    println(s"Divide Partial Function : ${divide2.lift(7)}")
    println(s"Divide Partial Function : ${divide2(7)}")

  }

  val divide = new PartialFunction[Int,Int]{

    def apply(x:Int) = 42/x
    def isDefinedAt(x:Int) = x!=0
  }.lift

  println("Divide Partial Function : " + divide(5))

//  Second way of Defining the partialFunction
  val divide2:PartialFunction[Double,Double] = {
    case x if x!=0 => 42/x
  }

}
