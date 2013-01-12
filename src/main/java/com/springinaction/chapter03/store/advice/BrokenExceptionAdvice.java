package com.springinaction.chapter03.store.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.springinaction.chapter03.store.BrokenException;

public class BrokenExceptionAdvice implements ThrowsAdvice {
	static Logger log = Logger.getLogger(BrokenException.class);
	
	public void afterThrowing(Method method, Object[] args, Object target, BrokenException ex)
	{
		log.error("发生Broken异常！");
		
	}
	
}
