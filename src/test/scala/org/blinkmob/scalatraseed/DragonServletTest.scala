package org.blinkmob.scalatraseed

import org.junit.runner.RunWith
import org.scalatra.test.specs2.ScalatraSpec
import org.specs2.runner.JUnitRunner
import org.json4s.jackson.Serialization._
import org.json4s.DefaultFormats
import org.json4s.Formats

@RunWith(classOf[JUnitRunner])
class DragonServletTest extends ScalatraSpec {
  implicit val jsonFormats: Formats = DefaultFormats
  
  def is = s2"""
    GET /dragon
      gets you some sweet dragons $getDragons
  """
      
  addServlet(new DragonServlet, "/dragon")
  
  def getDragons = get("/dragon"){
    val resp = read[List[Dragon]](response.body)
    resp must contain(Dragon(1, "BLUE", "Saphira"), Dragon(2, "GREEN", "Puff"))
  }
}