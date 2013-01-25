package wu.cg.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 4)
public class MessageAround1Advice {

    @Around("wu.cg.demo.spring.MessageAspect.logAccess() && args(arg0,..)")
    public Object logAround(ProceedingJoinPoint pjp, Object arg0)
	    throws Throwable {
	System.out.println("around1 开始...");

	String name = pjp.getSignature().getName();
	System.out.println("Around1 Advice中方法名:" + name);
	System.out.println("Around1 Advice中arg0:" + arg0);

	Object ret = pjp.proceed();
	System.out.println("around1 结束...");
	return ret;
    }
}
