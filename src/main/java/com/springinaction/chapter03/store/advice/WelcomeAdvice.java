package com.springinaction.chapter03.store.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.springinaction.chapter03.store.Customer;

public class WelcomeAdvice implements MethodBeforeAdvice {
	private static Logger log = Logger.getLogger(WelcomeAdvice.class);
	
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		log.info(method.getName()+"被调用");
		Customer cust = (Customer)args[0];
		log.info("欢迎您："+cust.getName());
	}
}
