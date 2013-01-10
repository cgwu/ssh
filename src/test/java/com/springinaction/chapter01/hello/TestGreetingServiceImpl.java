package com.springinaction.chapter01.hello;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGreetingServiceImpl {
    static Logger log = Logger.getLogger(TestGreetingServiceImpl.class);
    
    @Test
    public void testSayGreeting() {
	log.info("testSayGreeting开始");
	//ApplicationContext context = new ClassPathXmlApplicationContext("spring/hello.xml");
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	GreetingService service = context.getBean("greetingService", GreetingServiceImpl.class);
	service.sayGreeting();
	assertNotNull(service);
	
//	log.info(context.hashCode());
//	for(int i=0;i<10;i++){
//	    GreetingService stmp = context.getBean("greetingService", GreetingServiceImpl.class);
//	    log.info(i + ":" + stmp.hashCode());
//	}
	
    }

}
