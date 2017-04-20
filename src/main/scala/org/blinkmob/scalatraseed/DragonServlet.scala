package org.blinkmob.scalatraseed

import com.smartrac.scalatraseed.utils.BaseServlet
import anorm._
 
case class Dragon(ID:Int, DRAGON_TYPE:String, NAME:String)

class DragonServlet extends BaseServlet{

  get("/"){
    logger.info("getting some dragons...")
    DB.cx{implicit c =>
      SQL"""select ID, DRAGON_TYPE, NAME from DRAGON"""
        .as(Macro.namedParser[Dragon].*)
    }
  }
  
}