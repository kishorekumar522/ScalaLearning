package com.ykk.basic

/**
  * Created by kishoreyakkala on 30/08/16.
  */
object FirstClassFunctions extends App{

//  Functions that accept other functions as parameters and/or use functions
//   as return values are known as higher-order functions

//  Map is one of the finest examples for firstClassFunctions

  println("Check Palindrome and Count => ")
  validateNCountString("Hello1", isPalindrome)
  println("Check Digits and Count => ")
  validateNCountString("Hello1", hasDigits)

  val doAttack = strategyAct(true)
  println(doAttack(100))

  val doDefend = strategyAct(false)
  println(doDefend(50))

  def isPalindrome(str:String):Boolean = str.equals(str.reverse)
  def hasDigits(str:String):Boolean = str.exists(c => c.isDigit)

//  Validator is the first order function; where function is passed as arg
  def validateNCountString(str:String, validator: String=> Boolean): Unit ={
    println("Length : " + str.length)
    println("Validate : " + validator(str))
  }

//  strategyAct is the first order function; where function is returned as val
  def strategyAct(enoughPower:Boolean) = if(enoughPower) (energy:Double) => s"we are going to attach with Power : $energy"
  else (energy:Double) => s"we are going to defend with Energy : $energy"
}
