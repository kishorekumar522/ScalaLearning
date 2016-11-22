package com.ykk.monods

/**
  * Created by kishoreyakkala on 17/11/16.
  */
object UseCaseTest1 extends App{

  try{
    println(new FooA().getBar().getBoo.compute())
  }catch{
    case e:Exception=>e.printStackTrace()
  }

  var fL = for {b <- new FooL().getBar()
              bo <- b.getBoo()
              }yield bo.compute()

  fL.foreach(println)

}

class FooA(){
  def getBar():BarA=new BarA()
}

class BarA{
  def getBoo:BooA=new BooA()
//  def getBoo:BooA=null
}

class BooA{
  def compute():Int = 12
}

class FooL(){
  def getBar():List[BarL]=List(new BarL())
}

class BarL(){
//  def getBoo():List[BooL]=List(new BooL())
  def getBoo():List[BooL]=List.empty[BooL]
}

class BooL(){
  def compute():Int=23
}