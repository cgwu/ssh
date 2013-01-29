package com.springinaction.chapter01.hello.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.springinaction.chapter01.hello.GreetingServiceImpl;

public class SayGreetingLogBeforeAdvice implements MethodBeforeAdvice {
    static Logger log = Logger.getLogger(SayGreetingLogBeforeAdvice.class);

    public void before(Method method, Object[] args, Object target)
	    throws Throwable {
	log.info("AOP BEGIN.");
	log.info("被拦截的类:" + target.getClass() + ",方法:" + method.getName());
	GreetingServiceImpl service = (GreetingServiceImpl) target;
	service.sayGreeting();
	log.info("AOP END.");
    }
}
