package com.ykk.demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by kishoreyakkala on 31/08/16.
  */
object WordCountTest {

  def main(args: Array[String]) {
    val sconf = new SparkConf().setAppName("Word Count")
    val sc = new SparkContext(sconf)

    val fn = "/Users/kishoreyakkala/setup/spark-2.0.0-bin-hadoop2.7/LICENSE"

    sc.textFile(fn).flatMap(_.split("\\s+"))
      .map((_,1)).groupByKey().foreach(wc => println(s"${wc._1} : ${wc._2.sum}"))
  }
}

