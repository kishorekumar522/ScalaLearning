package com.ykk.Demo

/**
  * Created by kishoreyakkala on 18/10/16.
  */
object FunctionalTest extends App{

  implicit def voteValidator(p:Person)= p.age match{
    case x if x<18 => false
    case x if x>=18 => true
  }

  val pList = List(Person("kishore", 26), Person("shrrey", 12), Person("Jhon", 18), Person("Hari", 17))

  val peopleInfo = new PeopleInfo()

  peopleInfo.getVoteEligibility(pList)

}

case class Person(name:String, age:Int)

class PeopleInfo(implicit voteValidator:Person=>Boolean){

  def getVoteEligibility(pList : List[Person])= pList.foreach(p=>println(toVoteDisplay(p)))
  def toVoteDisplay(p:Person) = s"${p.name} is ${if(!voteValidator(p)) "Not" else ""} eligible for Voting"
}