package com.minhvu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student customer = new Student();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setAddress(rs.getString("address"));
		return customer;
	}
}