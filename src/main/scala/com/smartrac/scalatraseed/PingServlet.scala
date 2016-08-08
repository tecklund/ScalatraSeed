package com.smartrac.scalatraseed

import com.smartrac.scalatraseed.utils.{BaseServlet, Json, Logging}
import org.scalatra.ScalatraServlet

/**
  * Created by tim on 8/8/16.
  */
class PingServlet extends BaseServlet{

  get("/"){
    "ping"
  }

  get("/pong"){
    "pong"
  }

}
