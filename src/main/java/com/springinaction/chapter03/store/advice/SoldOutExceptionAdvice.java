package com.springinaction.chapter03.store.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.springinaction.chapter03.store.SoldOutException;

public class SoldOutExceptionAdvice implements ThrowsAdvice {
	static Logger log = Logger.getLogger(SoldOutExceptionAdvice.class);
	
	public void afterThrowing(Method method, Object[] args, Object target, SoldOutException ex)
	{
		log.error("发生SoldOut异常！");
		
	}
	
}
