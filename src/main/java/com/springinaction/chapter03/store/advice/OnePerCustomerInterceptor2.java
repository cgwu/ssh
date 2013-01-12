package com.springinaction.chapter03.store.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class OnePerCustomerInterceptor2 implements MethodInterceptor {
	static Logger log = Logger.getLogger(OnePerCustomerInterceptor2.class);
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("/*2222开始买苹果*/");
		Object returnValue = invocation.proceed();
		log.info("/*2222完成买苹果*/");
		return returnValue;
	}

}
