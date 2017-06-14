package org.blinkmob.scalatraseed

import org.blinkmob.scalatraseed.utils.BaseServlet
import anorm._
import java.sql.Connection
import org.blinkmob.models.Dragon

class DragonServlet extends BaseServlet{

  get("/"){
    logger.info("getting some dragons...")
    DB.tx{implicit c:Connection =>
       Dragon.getAll()
    }
  }
  
}