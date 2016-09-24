package com.ykk.Demo

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by kishoreyakkala on 24/09/16.
  */
object BestTeam{

  def main(args: Array[String]) {
    val scores = Map("a"->8,"b"->4,"c"->3,"d"->2,"e"->1,"f"->1)

    val totTeams = 2
    val totMembers = scores.size

//    teamCombination(scores.toArray, totMembers).foreach{teams=>{
//      teams.foreach(print)
//      println
//    }}

    getBestTeam(teamCombination(scores.toArray, totMembers), totTeams, totMembers).foreach{team =>
      team.foreach(print)
      println
    }

  }

  def teamCombination(teamMembers:Array[(String, Int)], tSize:Int):Array[Array[(String, Int)]]={

    val teamsArrBf = ArrayBuffer[Array[(String, Int)]]()

      def getMixAndMatch(remTMemb:mutable.Buffer[(String, Int)], rsltTeam:ArrayBuffer[(String,Int)]):Unit={

        (0 to remTMemb.length-1).map{idx=>
          val rmClone = remTMemb.clone()
          val tmpClone = rsltTeam.clone()
          tmpClone.append(rmClone.remove(idx))
          if(tmpClone.length==tSize){
            teamsArrBf.append(tmpClone.toArray)
          }else
            getMixAndMatch(rmClone,tmpClone)
        }
      }

    getMixAndMatch(teamMembers.toBuffer, ArrayBuffer.empty[(String, Int)])
    teamsArrBf.toArray
  }

  def getBestTeam(teams:Array[Array[(String,Int)]], tCount:Int, totMembers:Int):Array[Array[(String, Int)]]={
    val tSize = totMembers%tCount match{
      case 1 => 0
      case 0 => totMembers/tCount
    }
    if(tSize==0) return null

    val avgScore = teams(0).map(_._2).sum.toDouble/tCount

    def min(t1:(Double, Array[Array[(String, Int)]]), t2:(Double, Array[Array[(String, Int)]])) = if(t1._1 > t2._1) t2 else t1

    teams.map{ team =>
      val tGroup = team.grouped(tSize).toArray
      (tGroup.map{grp => math.abs(avgScore - grp.map(_._2).sum)}.sum, tGroup)
    }.reduce(min)._2
  }
}
