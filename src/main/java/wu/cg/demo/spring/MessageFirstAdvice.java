package wu.cg.demo.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value=1)
public class MessageFirstAdvice {

    @Before("wu.cg.demo.spring.MessageAspect.logAccess() && args(arg0,..)")
    public void logBefore1(JoinPoint pjp,Object arg0) {
	System.out.println("logBefore from 1 advice...");
	String name = pjp.getSignature().getName();
	
	System.out.println("Before1 Advice中方法名:" + name);
	
	System.out.println("Before1 Advice中 arg0:" + arg0);
    }

}
