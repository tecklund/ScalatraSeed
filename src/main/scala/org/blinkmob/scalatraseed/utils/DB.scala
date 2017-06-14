package org.blinkmob.scalatraseed.utils

import org.blinkmob.CxProvider
import org.blinkmob.hasDataSource
import com.zaxxer.hikari.HikariDataSource
import com.zaxxer.hikari.HikariConfig
import com.typesafe.config.ConfigFactory



object DB extends CxProvider with hasDataSource with Logging{
  
  val conf = ConfigFactory.load()
  
  val dbUrl = conf.getString(s"dbUrl")
  val dbUsername = conf.getString(s"dbUser")
  val dbPassword = conf.getString(s"dbPassword")
  
  logger.error(s"dbUrl is $dbUrl")
  
  var config = new HikariConfig();
  config.setJdbcUrl(dbUrl)
  config.setUsername(dbUsername)
  config.setPassword(dbPassword)
  config.setDriverClassName("com.mysql.cj.jdbc.Driver")
  
  val ds = new HikariDataSource(config)  
}

