package com.springinaction.chapter04.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

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

    public Person findById(Long id) {
	final Person p = new Person();
	String sql="SELECT id,name,birthday FROM Person where id = ?";
	jdbcTemplate.query(sql,new Object[]{ id}, new RowCallbackHandler() {
	    public void processRow(ResultSet rs) throws SQLException {
		p.setId(rs.getLong("id"));
		p.setName(rs.getString("name"));
		p.setBirthday(rs.getTimestamp("birthday"));
	    }
	});
	return p;
    }

}
