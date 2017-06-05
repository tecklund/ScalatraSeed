import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import org.blinkmob.scalatraseed.PingServlet
import org.blinkmob.scalatraseed.DragonServlet
import com.zaxxer.hikari.HikariDataSource
import org.blinkmob.scalatraseed.TXDBW

class ScalatraBootstrap extends LifeCycle {

  
  
  override def init(context: ServletContext) {

    // mount servlets like this:
    context mount (new PingServlet, "/ping")
    context mount (new DragonServlet(new TXDBW), "/dragon")
  }
}