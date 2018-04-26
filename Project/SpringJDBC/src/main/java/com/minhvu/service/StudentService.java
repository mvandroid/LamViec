package com.minhvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minhvu.dao.StudentDao;
import com.minhvu.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao customerDAO;

	public List<Student> findAll() {
		return customerDAO.findAll();
	}

	public Student findById(int id) {
		return customerDAO.findById(id);
	}

	public void save(Student customer) {
		// validate business
		customerDAO.save(customer);
	}

	public void update(Student customer) {
		// validate business
		customerDAO.update(customer);
	}

	public void delete(int id) {
		// validate business
		customerDAO.delete(id);
	}
}