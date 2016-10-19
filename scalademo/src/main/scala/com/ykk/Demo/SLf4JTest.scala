package com.ykk.Demo

import org.apache.log4j.PropertyConfigurator
import org.slf4j.LoggerFactory

/**
  * Created by kishoreyakkala on 19/10/16.
  */
object SLf4JTest{

  def main(args: Array[String]) {

  PropertyConfigurator.configure(System.getProperty("log4j.configuration"))
  val logger = LoggerFactory.getLogger(this.getClass)
  logger.info(s"logger property : ${System.getProperty("log4j.configuration")}")
  logger.info("Hello SLF4J Test")

  }

}
