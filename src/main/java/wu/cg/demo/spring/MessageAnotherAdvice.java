package wu.cg.demo.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value=2)
public class MessageAnotherAdvice {

    @Before("wu.cg.demo.spring.MessageAspect.logAccess()")
    public void logBefore2() {
	System.out.println("logBefore from 2 advice...");
    }

}
