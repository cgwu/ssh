package wu.cg.demo.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(value = 0)
public class MessageAround2Advice {

    @Around("wu.cg.demo.spring.MessageAspect.logAccess()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
	System.out.println("around2 开始...");
	
	String name = pjp.getSignature().getName();
	System.out.println("Around2 Advice中方法名:" + name);
	Object ret = pjp.proceed();
	System.out.println("around2 结束...");
	return ret;
    }
}
