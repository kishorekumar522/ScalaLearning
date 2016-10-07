package com.ykk.Demo

import scala.collection.mutable.ArrayBuffer

/**
  * Created by kishoreyakkala on 03/10/16.
  */
object TreeVisibility extends App{

  val t1 = Tree(5, Tree(3, Tree(20, null, null), Tree(21, null, null)), Tree(10, Tree(1, null, null), null))
//  println("Result : " + solution1(t1))

  val t2 = Tree(5, Tree(3, null, null), Tree(10, Tree(12, Tree(21, null, null), Tree(20, null, null)), null))
//  println("Max side Height : " + solution2(t2))

  val t3 = Tree(5, Tree(8, Tree(12, null, null), Tree(2, null, null)), Tree(9, Tree(7, Tree(1, null, null), null), Tree(4, Tree(1, null, null), null)))
  println("Amplitud : " + solution3(t3))

  def solution1(t: Tree): Int = {
    var rslt = 0

    def search(lrgeVal:Int, subTree:Tree): Unit ={
      if(subTree!=null){
        if(lrgeVal<=subTree.x) rslt+=1
        if(subTree.l!=null) search(math.max(lrgeVal, subTree.x), subTree.l)
        if(subTree.r!=null) search(math.max(lrgeVal, subTree.x), subTree.r)
      }
    }

    if(t!=null) search(t.x, t)
    rslt
  }

  def solution2(t: Tree): Int = {

    val arrbf = ArrayBuffer[Int](-1)
    def maxSideLength(lftHeight:Int, rtHeight:Int, subTree:Tree):Unit={

      if(subTree!=null){
       if(subTree.l==null) arrbf.append(lftHeight)
        else maxSideLength(lftHeight+1, rtHeight, subTree.l)
       if(subTree.r==null) arrbf.append(rtHeight)
         else maxSideLength(lftHeight, rtHeight+1, subTree.r)
      }
    }

    if(t!=null) maxSideLength(0,0,t)
    arrbf.max
  }

  def solution3(t: Tree): Int = {
    val arrbf = ArrayBuffer[Int]()

    def amplitudeOfPath(smlVal:Int, largeVal:Int, subTree:Tree):Unit={
      if(subTree!=null){
        if(subTree.l==null || subTree.r==null) arrbf.append(largeVal-smlVal)
        if(subTree.l!=null) amplitudeOfPath(math.min(smlVal, subTree.l.x), math.max(largeVal, subTree.l.x), subTree.l)
        if(subTree.r!=null) amplitudeOfPath(math.min(smlVal, subTree.r.x), math.max(largeVal, subTree.r.x), subTree.r)
      }
    }

    if(t!=null) amplitudeOfPath(t.x, t.x, t)
    arrbf.max
  }
}

case class Tree(var x:Int, var l:Tree, var r:Tree)

