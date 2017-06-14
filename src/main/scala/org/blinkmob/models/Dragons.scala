package org.blinkmob.models

import anorm._
import java.sql.Connection
 
case class Dragon(ID:Int, DRAGON_TYPE:String, NAME:String)

object Dragon {
  
  def getAll()(implicit c:Connection) = {
    SQL"""select ID, DRAGON_TYPE, NAME from DRAGON"""
        .as(Macro.namedParser[Dragon].*)
  }
}