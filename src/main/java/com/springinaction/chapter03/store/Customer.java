package com.springinaction.chapter03.store;

public class Customer {
	private String name;
	
	private Boolean broken;


	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getBroken() {
		return broken;
	}

	public void setBroken(Boolean broken) {
		this.broken = broken;
	}
	
	@Override
	public String toString() {
		return "Name:"+name +",broken:"+broken;
	}

}
