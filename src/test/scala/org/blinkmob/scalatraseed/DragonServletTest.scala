package org.blinkmob.scalatraseed

import org.junit.runner.RunWith
import org.scalatra.test.specs2.ScalatraSpec
import org.specs2.runner.JUnitRunner
import org.json4s.jackson.Serialization._
import org.json4s.DefaultFormats
import org.json4s.Formats
import org.blinkmob.models.Dragon
import org.specs2.specification.ForEach
import org.specs2.execute.AsResult
import org.specs2.execute.Result
import java.sql.Connection
import org.scalatra.test.specs2.MutableScalatraSpec
import org.blinkmob.scalatraseed.utils.DB
import org.specs2.matcher.MatchResult
import org.json4s.ext.JavaTimeSerializers

@RunWith(classOf[JUnitRunner])
class DragonServletTest extends MutableScalatraSpec {
  implicit val jsonFormats: Formats = DefaultFormats ++ JavaTimeSerializers.all
  
  def D1:PartialFunction[Dragon, MatchResult[_]] = {case Dragon(1, "BLUE", "Saphira", _) => ok}
  def D2:PartialFunction[Dragon, MatchResult[_]] = {case Dragon(2, "GREEN", "Puff", _) => ok}
      
  addServlet(new DragonServlet, "/dragon")
  
  "GET / on HelloWorldServlet" should {
    "return status 200" in {
      get("/dragon"){
        val resp = read[List[Dragon]](response.body)
        resp must contain(exactly(beLike(D1), beLike(D2)))
      }
    }
  }
  
}



trait DatabaseContext extends ForEach[Connection] {
  // you need to define the "foreach" method
  def foreach[R: AsResult](f: Connection => R): Result = {
    DB.rbtx { c => AsResult(f(c)) }
  }
}