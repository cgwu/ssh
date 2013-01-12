package com.springinaction.chapter03.store;

import org.apache.log4j.Logger;

public class AppleMarket implements Market {
	static Logger log = Logger.getLogger(AppleMarket.class);
	
	private Boolean isEmpty;

	public Apple buyApple(Customer cust) throws Exception {
		if(cust.getBroken()){
			throw new BrokenException();
		}
		if(isEmpty){
			throw new SoldOutException();
		}
		log.info(cust.getName()+"正在买苹果...");
		return new Apple("富士");
	}

	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public String toString() {
		return this.getClass()+",isEmpty:"+this.isEmpty;
	}

	public void buySth() {
		log.info("Buy Sth called...");
		
	}
}
