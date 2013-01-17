package com.springinaction.chapter04.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {

    @Test
    public void test() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/database.xml");
	BasicDataSource ds = context.getBean("dataSource", BasicDataSource.class);
	 try {
	    Connection conn = ds.getConnection();
	    assertNotNull(conn);
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM T");
	    while(rs.next()){
		int id = rs.getInt("ID");
		String name = rs.getString("Name");
			
		System.out.println(id+","+name);
	    }
	    stmt.close();
	    conn.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
    }

}
