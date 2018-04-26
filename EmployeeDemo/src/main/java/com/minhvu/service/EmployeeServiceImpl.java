package com.minhvu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.minhvu.dao.EmployeeDao;
import com.minhvu.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List listAllUser() {
		return employeeDao.listAllUser();
	}

	public void addUser(Employee employee) {
		employeeDao.addUser(employee);
	}

	public void updateUser(Employee employee) {
		employeeDao.updateUser(employee);
	}

	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

	public Employee findUserById(Employee employee) {
		return employeeDao.findUserById(employee);
	}


}
