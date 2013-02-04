package com.thinkinginjava.enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Season {
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");

    static Logger log = LoggerFactory.getLogger(Season.class);

    private Season(String desc) {
	this.desc = desc;
    }

    private String desc;

    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

    @Override
    public String toString() {
	return this.desc;
    }

    public static void main(String[] args) {
	for (Season s : Season.values()) {
	    log.info("ordinal:{},toStr:{},eq SPRING:{},==SPRING:{}",
		    s.ordinal(), s, s.equals(Season.SPRING), s == Season.SPRING);
	}
    }
}
