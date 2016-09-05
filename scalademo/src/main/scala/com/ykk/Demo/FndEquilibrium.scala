package com.ykk.Demo

import scala.collection.mutable.ArrayBuffer
import scala.runtime.BoxedUnit

/**
  * Created by kishoreyakkala on 18/09/16.
  */
object FndEquilibrium extends App{

//  This is a demo task. You can read about this task and its solutions in this blog post.
//
//    A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
//    A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
//  Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
//
//  For example, consider the following array A consisting of N = 8 elements:
//
//    A[0] = -1
//  A[1] =  3
//  A[2] = -4
//  A[3] =  5
//  A[4] =  1
//  A[5] = -6
//  A[6] =  2
//  A[7] =  1
//  P = 1 is an equilibrium index of this array, because:
//
//    A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]


  val array = Array(-1,3,-4,5,1,-6,2,1)

  getEquilibrium(array)

  def getEquilibrium(arr:Array[Int])={

    var aSize = arr.size
    var tIdx = 0
    var lftSum = 0

    (0 to aSize-1).map{i=>
      lftSum+=arr(i)
      tIdx +=1
//      println(s"i=$i ; lftSum=$lftSum ; rgtSum=${arr.takeRight(aSize-tIdx-1).sum} ; tIdx=$tIdx")
      if(lftSum==arr.takeRight(aSize-tIdx-1).sum) tIdx
    }.filter(!_.isInstanceOf[BoxedUnit]).foreach(println)

  }
}
