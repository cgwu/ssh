package com.strutsinaction.domain;

public class Portfolio {

    private String name;

    private User owner;

    private Long id;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public User getOwner() {
	return owner;
    }

    public void setOwner(User owner) {
	this.owner = owner;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}
