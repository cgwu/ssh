package wu.cg.demo.slf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.core.util.StatusPrinter;

public class HelloWorld {
    static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    static final Logger logMail = LoggerFactory.getLogger("mail.logger");
    public static void main(String[] args) {
	for (int i = 0; i < 5; i++) {
	    logMail.error("邮件日志测试,日志内容.{}+{}={}", i, i, i + i);
	}
	doFoo();
	
//	logger.info("done");
	System.out.println(1+1);
	// print internal state
//	LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//	StatusPrinter.print(lc);
    }
    
    static void doFoo(){
	logger.debug("Foo发生");
    }
}