package com.strutsinaction.chapter02;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class TestAjax {
    static Logger log = LoggerFactory.getLogger(TestAjax.class);

    private static final String GREETING = "您好: ";

    private User model;
    private Map rsp;

    public String execute() {
//	setCustomGreeting(GREETING + model.getName());
	
	rsp = new HashMap();
	rsp.put("code", 1);
	rsp.put("msg", "成功");
	rsp.put("model", model);
	rsp.put("now", new Date());
	rsp.put(110, "中国");
	rsp.put("greetingString", this.getCustomGreeting());
	return Action.SUCCESS;
    }

    private String customGreeting;

    public String getCustomGreeting() {
	return customGreeting;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message="customGreeting is required.")
    public void setCustomGreeting(String customGreeting) {
	this.customGreeting = customGreeting;
    }

    public User getModel() {
	return model;
    }

    public void setModel(User model) {
	this.model = model;
    }

    public Map getRsp() {
	return rsp;
    }
}
