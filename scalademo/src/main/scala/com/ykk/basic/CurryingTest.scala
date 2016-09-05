package com.ykk.basic

/**
  * Created by kishoreyakkala on 29/08/16.
  */
object CurryingTest{

//  Currying vs Partial applied functions

//  Currying real time functions are foldLeft, foldRight
//  Partial Applied functions are used to define and execute at different places based on requirement

  def main(args: Array[String]) {
    println(s"Add => ${mathOp("+")(1,2)}")
    println(s"Sub => ${mathOp("-")(1,2)}")
    println(s"Mul => ${mathOp("*")(1,2)}")
    println(s"Div => ${mathOp("/")(2,2)}")

    println(s"DivBy2 => ${divBy2(10)}")
    println(s"DivBy3 => ${divBy3(10)}")
  }

    def mathOp(op:String)(op1:Int, op2:Int) : Double = op match {
      case "+" => op1 + op2
      case "-" => op1 - op2
      case "*" => op1 * op2
      case "/" if op2!=0 => op1 / op2

    }

    def divide(divisor:Int)(x:Int):Double = x/divisor

    val divBy2 = divide(2)_
    val divBy3 = divide(3)_
}
