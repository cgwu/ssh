package com.springinaction.chapter01.hello;

import org.springframework.beans.factory.BeanNameAware;

public class GreetingServiceImpl implements GreetingService, BeanNameAware {

	private String greeting;

	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public GreetingServiceImpl() {
	    System.out.println(this.getClass()+" : 被构造");
	}

	public GreetingServiceImpl(String greeting) {
		this.greeting = greeting;
		System.out.println(this.getClass()+" : 被构造@1");
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void sayGreeting() {
		System.out.println("BeanName:"+this.beanName+","+greeting);
	}

	public void setBeanName(String paramString) {
		System.out.println("Bean Name:" + paramString);
		this.beanName = paramString;
	}

}
