import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import com.smartrac.scalatraseed.PingServlet
import org.blinkmob.scalatraseed.DragonServlet
import com.zaxxer.hikari.HikariDataSource

class ScalatraBootstrap extends LifeCycle {

  
  
  override def init(context: ServletContext) {

    // mount servlets like this:
    context mount (new PingServlet, "/ping")
    context mount (new DragonServlet, "/dragon")
  }
}