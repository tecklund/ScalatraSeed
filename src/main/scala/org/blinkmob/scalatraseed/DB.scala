package org.blinkmob.scalatraseed

import org.blinkmob.CxProvider
import org.blinkmob.hasDataSource
import com.zaxxer.hikari.HikariDataSource
import com.zaxxer.hikari.HikariConfig

object DB extends CxProvider with hasDataSource{
  
  var config = new HikariConfig();
  config.setJdbcUrl("jdbc:h2:file:./target/foobar");
  config.setUsername("sa")
  
  val ds = new HikariDataSource(config)  
}