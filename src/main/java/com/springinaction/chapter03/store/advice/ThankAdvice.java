package com.springinaction.chapter03.store.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.springinaction.chapter03.store.Apple;
import com.springinaction.chapter03.store.Customer;

public class ThankAdvice implements AfterReturningAdvice {
	static Logger log = Logger.getLogger(ThankAdvice.class);

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		log.info("ThankAdvice called.");
		if (returnValue instanceof Apple) {
			Apple apple = (Apple) returnValue;
			Customer cust = (Customer) args[0];
			log.info("恭喜" + cust.getName() + "买到" + apple.getName()
					+ ",欢迎再次光临！");
		}
	}
}
