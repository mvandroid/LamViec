package com.minhvu.service;

import java.util.List;

import com.minhvu.model.Employee;

public interface EmployeeService {
	public List listAllUser();

	public void addUser(Employee employee);

	public void updateUser(Employee employee);

	public void delete(Employee employee);

	public Employee findUserById(Employee employee);
}
