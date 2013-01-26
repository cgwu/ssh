package wu.cg.demo.servlet;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionLogListener implements HttpSessionListener {
	
	static Logger log = LoggerFactory.getLogger(SessionLogListener.class);
	
	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {
		HttpSession session = paramHttpSessionEvent.getSession();
		log.debug("sessionCreated:" + session.getId());
	}
 
	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {
		HttpSession session = paramHttpSessionEvent.getSession();
		log.debug("sessionDestroyed.."+ session.getId());
	}

}
