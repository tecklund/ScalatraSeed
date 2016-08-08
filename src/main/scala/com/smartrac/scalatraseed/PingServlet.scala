package com.smartrac.scalatraseed

import org.scalatra.ScalatraServlet

/**
  * Created by tim on 8/8/16.
  */
class PingServlet extends ScalatraServlet{

  get("/"){
    "ping"
  }

}
