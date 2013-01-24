package wu.cg.demo.slf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class HelloWorld {
//    static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    static final Logger logger = LoggerFactory.getLogger("ABC");
    public static void main(String[] args) {
	logger.error("Hello world.我的日志内容new");
	doFoo();
	// print internal state
//	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//	StatusPrinter.print(lc);
    }
    
    static void doFoo(){
	logger.error("Foo发生");
    }
}