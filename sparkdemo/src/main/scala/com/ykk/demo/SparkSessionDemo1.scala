package com.ykk.demo

import org.apache.spark.sql.SparkSession

/**
  * Created by kishoreyakkala on 21/11/16.
  */
object SparkSessionDemo1 {

  def main(args: Array[String]) {
    val ss = SparkSession.builder().appName("First Spark Session").master("spark://localhost:7077").getOrCreate()

    println(ss.sparkContext.appName)
    ss.sparkContext.textFile("/Users/kishoreyakkala/setup/spark-2.0.0-bin-hadoop2.7/README.md").flatMap(_.split(" ").map((_,1))).reduceByKey(_+_).foreach(println)

  }
}
