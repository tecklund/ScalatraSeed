import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import com.smartrac.scalatraseed.PingServlet

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {

    // mount servlets like this:
    context mount (new PingServlet, "/*")
  }
}