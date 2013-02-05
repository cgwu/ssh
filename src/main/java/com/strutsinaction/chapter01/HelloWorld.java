package com.strutsinaction.chapter01;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld implements ServletContextAware, ServletRequestAware, ParameterAware, RequestAware {
    static Logger log = LoggerFactory.getLogger(HelloWorld.class);
	    
    private static final String GREETING = "您好: ";

    private ServletContext context;
    private HttpServletRequest request;
    private Map<String, String[]> parameters;
    private Map<String, Object> requestMap;	//struts2 的Request包装
    
    public String execute() {
	log.info(context.getServerInfo());
	log.info("项目根目录:{}",context.getRealPath("/"));
	log.info("请求的相对路径:{}",request.getRequestURI());
	log.info("请求的完全路径:{}",request.getRequestURL());
	
	setCustomGreeting(GREETING + getName());
	return "SUCCESS";
    }

    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    private String customGreeting;

    public String getCustomGreeting() {
	return customGreeting;
    }

    public void setCustomGreeting(String customGreeting) {
	this.customGreeting = customGreeting;
    }

    @Override
    public void setServletContext(ServletContext context) {
	this.context = context;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
	this.request = request;
    }

    @Override
    public void setParameters(Map<String, String[]> parameters) {
	this.parameters = parameters;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
	requestMap = request;
    }
}
