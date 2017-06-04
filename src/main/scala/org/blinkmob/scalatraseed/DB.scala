package org.blinkmob.scalatraseed

import org.blinkmob.CxProvider
import org.blinkmob.hasDataSource
import com.zaxxer.hikari.HikariDataSource
import com.zaxxer.hikari.HikariConfig
import scala.util.Properties
import com.typesafe.config.ConfigFactory
import org.blinkmob.scalatraseed.utils.Logging
import java.sql.Connection


object DB extends CxProvider with hasDataSource with Logging{
  
  val conf = ConfigFactory.load()
  val env = conf.getString("env")
  
  logger.error(s"ENV IS $env")
  
  val dbUrl = conf.getString(s"${env}.dbUrl")
  val dbUsername = conf.getString(s"${env}.dbUser")
  val dbPassword = conf.getString(s"${env}.dbPassword")
  
  var config = new HikariConfig();
  config.setJdbcUrl(dbUrl)
  config.setUsername(dbUsername)
  config.setPassword(dbPassword)
  
  val ds = new HikariDataSource(config)  
}

abstract class DBW{
  def run[A](block: Connection => A):A
}

class TXDBW extends DBW{
  override def run[A](block: Connection => A):A = {
    DB.tx { block }
  }
}

class RBTXDBW extends DBW{
  override def run[A](block: Connection => A):A = {
    DB.rbtx { block }
  }
}

