package com.minhvu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minhvu.model.Student;
import com.minhvu.model.StudentMapper;

@Repository
@Transactional
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Student customer) {
		String sql = "INSERT INTO customer (name, address) VALUES (?, ?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getAddress());
	}

	public void delete(int id) {
		String sql = "DELETE FROM customer WHERE id = " + id;
		jdbcTemplate.update(sql);
	}

	public void update(Student customer) {
		String sql = "UPDATE customer SET name = ?, address = ? WHERE id = ? ";
		jdbcTemplate.update(sql, customer.getName(), customer.getAddress(), customer.getId());
	}

	public Student  findById(int id) {
		String sql = "SELECT * FROM customer WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new StudentMapper(), id);
	}

	public List<Student> findAll() {
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

}
