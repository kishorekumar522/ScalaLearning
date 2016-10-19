package com.ykk.Demo

import org.slf4j.LoggerFactory

/**
  * Created by kishoreyakkala on 19/10/16.
  */
object SLf4JTest{

  def main(args: Array[String]) {

//  can use propertyConfigurator or vm arguments as below
//  -Dlog4j.configuration=file:///Users/kishoreyakkala/git/ScalaLearning/scalademo/src/main/conf/log4j.properties
//  PropertyConfigurator.configure(System.getProperty("log4j.configuration"))

  val logger = LoggerFactory.getLogger(this.getClass)
  logger.info(s"logger property : ${System.getProperty("log4j.configuration")}")
  logger.info("Hello SLF4J Test")

  }

}
