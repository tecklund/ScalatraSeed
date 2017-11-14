package org.blinkmob.models

import anorm._
import java.sql.Connection
import java.time.LocalDateTime
 
case class Dragon(ID:Int, DRAGON_TYPE:String, NAME:String, TS:LocalDateTime)

object Dragon {
  
  def getAll()(implicit c:Connection) = {
    SQL"""select ID, DRAGON_TYPE, NAME, TS from DRAGON"""
        .as(Macro.namedParser[Dragon].*)
  }
}