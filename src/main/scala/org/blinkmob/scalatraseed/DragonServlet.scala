package org.blinkmob.scalatraseed

import org.blinkmob.scalatraseed.utils.BaseServlet
import anorm._
import java.sql.Connection
 
case class Dragon(ID:Int, DRAGON_TYPE:String, NAME:String)

class DragonServlet(db:DBW) extends BaseServlet{

  get("/"){
    logger.info("getting some dragons...")
    db.run{implicit c:Connection =>
      SQL"""select ID, DRAGON_TYPE, NAME from DRAGON"""
        .as(Macro.namedParser[Dragon].*)
    }
  }
  
}