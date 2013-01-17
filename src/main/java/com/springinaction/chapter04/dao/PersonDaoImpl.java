package com.springinaction.chapter04.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDaoImpl implements IPersonDao {
    private JdbcTemplate jdbcTemplate;
    
    public int add(Person p) {
	String sql="INSERT into Person (name,birthday) VALUES(?,?)";
	return jdbcTemplate.update(sql, p.getName(),p.getBirthday());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
