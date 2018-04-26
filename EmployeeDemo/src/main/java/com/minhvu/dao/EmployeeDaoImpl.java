package com.minhvu.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.minhvu.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAllUser() {
		List list = new ArrayList();

		String sql = "SELECT id, name, email FROM employee";

		list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new EmployeeMapper());

		return list;
	}

	public void addUser(Employee employee) {
		String sql = "INSERT INTO employee(name, email) VALUES(:name, :email)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(employee));

	}

	public void updateUser(Employee employee) {
		String sql = "UPDATE employee SET name=:name, email=:email WHERE id =:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(employee));

	}

	public void delete(Employee employee) {
		String sql = "DELETE FROM employee WHERE id=:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(employee));

	}

	public Employee findUserById(Employee user) {
		String sql = "SELECT * FROM employee WHERE id =:id";

		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(user), new EmployeeMapper());
	}

	private SqlParameterSource getSqlParameterByModel(Employee employee) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (employee != null) {
			parameterSource.addValue("id", employee.getId());
			parameterSource.addValue("name", employee.getName());
			parameterSource.addValue("email", employee.getEmail());
		}
		return parameterSource;
	}

}
