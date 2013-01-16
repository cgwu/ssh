package com.springinaction.chapter03.introduction;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIntroduction {

    static Logger log = Logger.getLogger(TestIntroduction.class);
    
    @Test
    public void test() {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring/introduction-demo.xml");
	
	ISome some = context.getBean("some", ISome.class);
	some.doSome();
	((IOther)some).doOther();
	log.info(some.hashCode());
	
	System.out.println("#############################");
	
	IOther other = context.getBean("some", IOther.class);
	other.doOther();
	((ISome)other).doSome();
	log.info(other.hashCode());
	
	assertNotNull(some);
	assertNotNull(other);
    }

}