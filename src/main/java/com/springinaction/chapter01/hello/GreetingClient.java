package com.springinaction.chapter01.hello;

public class GreetingClient {

    private GreetingService greetingService;
    
    public GreetingClient(){
	System.out.println(this.getClass()+" : 被构造");
    }
    

    public GreetingService getGreetingService() {
	return greetingService;
    }

    public void setGreetingService(GreetingService greetingService) {
	this.greetingService = greetingService;
    }
    
    public void callService(){
	this.greetingService.sayGreeting();	
    }

}
