package com.minhvu.service;

import java.util.List;

import com.minhvu.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public Employee getEmployee(int id);

	public int deleteEmployee(int id);

	public int updateEmployee(Employee employee);

	public int createEmployee(Employee employee);
}