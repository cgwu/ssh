package com.springinaction.chapter04.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.framework.core.util.DateUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonDaoImpl {
    static Logger log = Logger.getLogger(TestPersonDaoImpl.class);
    
    @Test
    public void testAdd() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/database.xml");
	IPersonDao personDao = context.getBean("personDao", IPersonDao.class);
	Person p = new Person();
	p.setName("吴xx~!!@#wucg");
	p.setBirthday(DateUtils.parseDate("1982-01-12 23:12:34",DateUtils.DEFAULT_DATE_TIME_PATTERN));
	//p.setBirthday(new Date(87,1,17));
	int iAffected = personDao.add(p);
	log.info("done");
	assertEquals(1, iAffected);
    }

    @Test
    public void testFindById() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/database.xml");
	IPersonDao personDao = context.getBean("personDao", IPersonDao.class);
	
	Person p = personDao.findById(1L);
	log.info(p.getName());
	log.info(p.getBirthday());
	
	log.info("done");
	assertTrue(p.getId().equals(1L));
    }
    
    @Test
    public void testFoo() {
	log.info("test foo");
	assertTrue(true);
    }
}
