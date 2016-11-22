package com.ykk.patterns

/**
  * Created by kishoreyakkala on 29/10/16.
  */
object FactoryPatternExample {

}

trait Animal{
  def getName():String
  def getAnimalBread():String
}

class Dog extends Animal{
  var name:String = null
  var aType:String = null

  override def getName(): String = s"Dog's Name : $name"

  override def getAnimalBread(): String = s"Bread of the Dog : $aType"
}

class Bird extends Animal{
  var name:String = null
  var aType:String = null
  override def getName(): String = s"Bird's Name : $name"

  override def getAnimalBread(): String = s"Bread of the Bird : $aType"
}

class AnimalFactory{

  def getAnimal(a:String):Animal = a match{
    case "dog" => new Dog()
    case "bird" => new Bird()
  }
}