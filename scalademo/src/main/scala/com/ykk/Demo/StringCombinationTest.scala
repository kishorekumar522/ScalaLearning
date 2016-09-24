package com.ykk.Demo

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by kishoreyakkala on 21/09/16.
  */
object StringCombinationTest{

  def main(args: Array[String]) {

    val arr: Array[String] = Array("a","b","c","d")

    combination(arr).foreach(println)

  }

  def combination[x<: Any](arr:Array[x]):Array[Any] = combination(arr, arr.length)
  def combination[x<: Any](arr:Array[x], size:Int):Array[Any]={

    val combStrm = ArrayBuffer[Any]()

    def getCombination[x<: Any](remArray:mutable.Buffer[x], strStream:Stream[Any]):Unit={
      (0 to remArray.length-1).foreach{idx=>
        val arrDuplicate = remArray.clone()
        val tmpStrm = strStream.append(arrDuplicate.remove(idx).toString)
        if(tmpStrm.length==size){
          combStrm.append(tmpStrm.mkString)
        }else
          getCombination(arrDuplicate, tmpStrm)
      }
    }

    getCombination(arr.toBuffer, Stream.empty[Any])
    combStrm.toArray

  }

}
