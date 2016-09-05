package com.ykk.demo

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import org.apache.spark.internal.Logging

/**
  * Created by kishoreyakkala on 05/09/16.
  */
object DataFrameExample{

  def main(args: Array[String]){

    val sConf = new SparkConf().setAppName("DF Log Processor")
    val sc = new SparkContext(sConf)
    val sqlContext = SparkSession.builder().getOrCreate().sqlContext
    import sqlContext.implicits._

    val logFldr = "file:///Users/kishoreyakkala/setup/spark-2.0.0-bin-hadoop2.7/logs"
    val logDF = sc.wholeTextFiles(logFldr).map(_._1).toDF("line")
    val infoCnt = logDF.filter(col("line").like("INFO")).count

    println(s"info Count : $infoCnt")
    logDF.filter(col("line").like("WARN")).foreach(println(_))
  }

}
