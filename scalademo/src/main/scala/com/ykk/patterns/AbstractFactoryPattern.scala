package com.ykk.patterns

/**
  * Created by kishoreyakkala on 29/10/16.
  */
object AbstractFactoryPattern {

}


trait MotorManufactures{
  def getBikes(motor:String)(name:String):Bike
  def getCars(motor:String):Car
}

trait Bajaj extends MotorManufactures
trait Mahandra extends MotorManufactures

trait Car{
  def getFuelType:String
  def getModel:String
}

trait Bike{
  def getModel:String
}

class BajajQute extends Car{
  var name = "Bajaj Qute"
  var model:String = "HatchBack"

  override def getFuelType = "Diesel"
  override def getModel = model
}

class MahandraSUV(name:String) extends Car{
  var model:String = "SUV"

  override def getFuelType: String = "Diesel"
  override def getModel: String = "SUV"
}

class BajajBike(name:String, model:String) extends Bike{
  override def getModel: String = model
}

class MahandraBike(name:String, model:String) extends Bike{
  override def getModel: String = model
}

class BikeFactory extends MotorManufactures{
  override def getBikes(motors:String)(name:String):Bike= motors match{
    case "bajaj" => new BajajBike(name, "mid Range")
    case "mahandra" => new MahandraBike(name, "mid Range")
  }

  override def getCars(motors:String): Car = null
}


class CarFactory extends MotorManufactures{
  override def getCars(motors:String): Car = motors match{
    case "bajaj" => new BajajQute()
    case "mahandra" => new MahandraSUV("T500")
  }

  override def getBikes(motor: String)(name: String): Bike = null
}

class MotorProducer{
  def getFactory(name:String):MotorManufactures= name match{
    case "car" => new CarFactory()
    case "bike" => new BikeFactory()
  }
}