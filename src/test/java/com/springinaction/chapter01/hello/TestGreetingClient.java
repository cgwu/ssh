package com.springinaction.chapter01.hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreetingClient {

    @Test
    public void test() {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	GreetingService service1 = context.getBean("greetingService", GreetingService.class);
	service1.sayGreeting();
	
	System.out.println("###########################################################");
	
	GreetingClient service = context.getBean("hello.greetingClient", GreetingClient.class);
	service.callService();
	assertNotNull(service);
	
	System.out.println("Service1:"+service1.hashCode());
	System.out.println("Client.Service:"+service.getGreetingService().hashCode());
    }
    
}
