package com.springinaction.chapter03.store.advice;

import java.util.HashSet;
import java.util.Set;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.springinaction.chapter03.store.Customer;

public class OnePerCustomerInterceptor implements MethodInterceptor {
	static Logger log = Logger.getLogger(OnePerCustomerInterceptor.class);
	private Set<String> setNames = new HashSet<String>();

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		if (args != null && args.length > 0 && args[0] instanceof Customer) {
			Customer cust = (Customer)args[0];
			if (setNames.contains(cust.getName())) {
				log.error(cust.getName() + ",已经买过一个苹果了，不能再买，失败！");
				return null;
			}
			setNames.add(cust.getName());
		}
		log.info("/*开始买苹果*/");
		Object returnValue = invocation.proceed();
		log.info("/*完成买苹果*/");
		
		return returnValue;
	}

}
