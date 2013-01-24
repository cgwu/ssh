package wu.cg.demo.slf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloWorld {
    static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
	logger.debug("Hello world.我的日志内容new");

	// print internal state
	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	StatusPrinter.print(lc);
    }
}