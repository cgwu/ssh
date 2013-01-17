package com.springinaction.chapter04.dao;

import java.util.Date;

/**
 * 
--sql def

create table Person(
id bigint identity,
name nvarchar(50),
birthday datetime
)

 * @author spark
 *
 */
public class Person {

    private Long id;
    private String name;
    private Date birthday;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

}
