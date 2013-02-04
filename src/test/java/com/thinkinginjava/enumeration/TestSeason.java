package com.thinkinginjava.enumeration;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSeason {
    static Logger log = LoggerFactory.getLogger(TestSeason.class);

    @Test
    public void test() {
	for (Season s : Season.values()) {
	    log.info("ordinal:{},toStr:{},eq SPRING:{},==SPRING:{}",
		    s.ordinal(), s, s.equals(Season.SPRING), s == Season.SPRING);
	}

	assertTrue(Season.SPRING == Season.valueOf("SPRING"));
	assertTrue(Season.SPRING == Enum.valueOf(Season.class,"SPRING"));
	assertEquals(0,Season.SPRING.compareTo(Season.valueOf("SPRING")));
	
	Season s = Season.SPRING;
	log.info(s.toString());
	s.setDesc("新的春天");
	log.info(s.toString());
	assertEquals(s,Season.SPRING);
	
	 EnumSet<Season> es = EnumSet.allOf(Season.class);
	 System.out.println(es);
	 
	 //EnumMap
	 
	 System.out.println( System.getenv("classpath"));
	 System.out.println( System.getenv("CLASSPATH"));
	 
	 System.out.println( System.getProperty("java.version"));
    }

}
