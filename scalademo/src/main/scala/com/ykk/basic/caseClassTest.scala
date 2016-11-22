package com.ykk.basic

/**
  * Created by kishoreyakkala on 22/10/16.
  */
object caseClassTest extends App{

  val e1 = Emp("kishore", 22)
  val e2 = Emp("kishore", 22)
  val e3 = Emp("kishore", 23)

  println(e1==e1)
  println(e1==e2)
  println(e1==e3)

}

case class Emp(name:String, eid:Int)
