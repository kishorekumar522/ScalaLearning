package com.ykk.demo

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType, StructType}
import org.apache.spark.sql.functions._
/**
  * Created by kishoreyakkala on 23/11/16.
  */
object DFJoinTest {

  def main(args: Array[String]) {

    val ss = SparkSession.builder().appName("Outer table Join Test").master("spark://localhost:7077").getOrCreate()

    //    val empPath = "file:///Users/kishoreyakkala/setup/dump/sparkdump/employees.json"
//    val depPath = "/Users/kishoreyakkala/setup/dump/sparkdump/departments.json"
////    spark works differently on multiline and singleline json file
    val empS = new StructType().add("employee_id", IntegerType).add("first_name", StringType).add("last_name", StringType).add("email", StringType).add("phone_number", StringType).add("hire_date", StringType).add("job_id", StringType).add("salary", DoubleType).add("commission_pct", DoubleType).add("manager_id", IntegerType).add("department_id", IntegerType)
    val depS = new StructType().add("department_id", IntegerType).add("department_name", StringType).add("manager_id", IntegerType).add("location_id",IntegerType)
//    val empDF = ss.sqlContext.read.schema(empS).json(ss.sparkContext.wholeTextFiles(empPath).map(fd => fd._2.replace("\n","")))
//    empDF.printSchema()
//    empDF.show()
//    println("emp Count : " + empDF.count())
//
//    val depDF = ss.sqlContext.read.json(ss.sparkContext.wholeTextFiles(depPath).map(fd => fd._2.replace("\n","")))

    val empPath = "/Users/kishoreyakkala/setup/dump/sparkdump/employees.csv"
    val empDF = ss.sqlContext.read.option("header", true).schema(empS).csv(empPath)
    empDF.createOrReplaceTempView("employees")
    val depPath = "/Users/kishoreyakkala/setup/dump/sparkdump/departments.csv"
    val depDF = ss.sqlContext.read.option("header", true).schema(depS).csv(depPath)
    depDF.createOrReplaceTempView("departments")

//    ss.sqlContext.sql("select department_name, first_name from employees e join departments d on e.department_id=d.department_id").show()
//    ss.sqlContext.sql("select m.first_name,e.first_name from employees e join employees m on e.manager_id=m.employee_id").show()

//    empDF.join(depDF, empDF.col("department_id")===depDF.col("department_id"), "inner").select(depDF.col("department_name"), empDF.col("first_name")).show()

    empDF.join(depDF, empDF.col("department_id")===depDF.col("department_id"), "inner")
      .select(depDF.col("department_name"), empDF.col("salary"))
        .filter(depDF.col("department_name").like("%ing"))
      .groupBy(depDF.col("department_name")).agg(sum("salary").alias("MaxSalary"))
      .show()

//    empDF.write.parquet("/Users/kishoreyakkala/setup/dump/sparkdump/employees.parquet")

  }
}
