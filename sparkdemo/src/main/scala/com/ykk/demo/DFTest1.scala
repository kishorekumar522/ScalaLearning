package com.ykk.demo

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
/**
  * Created by kishoreyakkala on 22/11/16.
  */
object DFTest1 {

  def main(args: Array[String]) {
    val dPath = "file:///Users/kishoreyakkala/setup/spark-2.0.0-bin-hadoop2.7/worker"

    val ss = SparkSession.builder().appName("Spark DF test").getOrCreate()


//    getFiles(dPath, "stderr").foreach{fp =>
//      ss.sparkContext.textFile(fp)
//    }

    val eCount = getFiles(dPath, "stderr").map{errFile =>
      import ss.sqlContext.implicits._
      ss.sparkContext.textFile(errFile).toDF("line").filter(col("line").contains("INFO")).count()
    }.sum

    println("eCount : " + eCount)

//    new Path(dPath).getFileSystem(new Configuration()).listStatus(new Path(dPath)).foreach(c => println(c.getPath))

  }

  def getFiles(dirPath:String, fName:String):List[String]= {
    def getFS(dPath:String) =new Path(dirPath).getFileSystem(new Configuration())

    val fs = getFS(dirPath)

    def matchingFiles(dPath: List[String]):List[String] = dPath flatMap {
      case fPath: String if fPath.contains(fName) && fs.isFile(new Path(fPath)) => List(fPath)
      case dp: String if fs.isDirectory(new Path(dp)) =>
        matchingFiles(fs.listStatus(new Path(dp)).map(_.getPath.toString).toList)
      case _ => List.empty[String]
    }

    matchingFiles(List(dirPath))
  }
}
