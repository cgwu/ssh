package com.springinaction.chapter04.dao;

public interface IPersonDao {

    public int add(Person p);
    
    public Person findById(Long id);
    
}
