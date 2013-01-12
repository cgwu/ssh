package com.springinaction.chapter03.store;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.chapter01.hello.GreetingService;
import com.springinaction.chapter01.hello.TestGreetingServiceImpl;

public class TestAppleMarket {
	static Logger log = Logger.getLogger(TestAppleMarket.class);
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/market.xml");
		Market market = context.getBean("appleMarket", Market.class);
		Customer zhangsan = context.getBean("zhangsan", Customer.class);
		assertNotNull(market);
		assertNotNull(zhangsan);
		
//		log.info(market);
//		log.info(zhangsan);
		
		Apple apple =null;
		try {
			apple = market.buyApple(zhangsan);
			Apple apple2 = market.buyApple(zhangsan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		log.info(apple.getName());
	}

}
