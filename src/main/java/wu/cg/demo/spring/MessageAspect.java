package wu.cg.demo.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
public class MessageAspect {
//    static final Logger log = LoggerFactory.getLogger(MessageAroundAspect.class);
    
    @Pointcut("execution(* wu.cg.demo.spring..*.*(..))")
    public void logAccess() {
    }
    
    //与切点定义在一块的Advice也是可以的
    /*
    @Before("logAccess()")
    public void logBefore() {
	System.out.println("logBefore...");
    }
    */
    
    /*
    @AfterReturning("logAccess()")
    public void logAround() {
	System.out.println("logAfter...");
    }
    */
}
