package com.ykk.demo

import org.apache.spark.sql.SparkSession

/**
  * Created by kishoreyakkala on 18/12/16.
  */
object MySqlRetrieval {

  def main(args: Array[String]) {

    val mysqlurl = "jdbc:mysql://localhost:3306/hr?user=root&password=system123"
    val myUrl = "jdbc:mysql://localhost:3306/hr"
    Class.forName("com.mysql.jdbc.Driver").newInstance

    val ss = SparkSession.builder().appName("MySql Retrieval").getOrCreate()

//    val emp = ss.sqlContext.read.format("jdbc").option("url", myUrl).option("user", "root")
//        .option("password", "system123").option("driver", "com.mysql.jdbc.Driver")
//        .option("dbtable", "employees").load()

    val emp = ss.sqlContext.read.format("jdbc").option("url", mysqlurl)
      .option("driver", "com.mysql.jdbc.Driver").option("dbtable", "employees").load()

    emp.show
  }
}
