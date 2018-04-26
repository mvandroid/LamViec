package com.minhvu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.minhvu.model.Employee;

public class EmployeeMapper implements RowMapper {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setEmail(rs.getString("email"));

		return employee;
	}
}
