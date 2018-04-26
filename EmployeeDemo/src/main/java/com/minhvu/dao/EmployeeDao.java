package com.minhvu.dao;

import java.util.List;

import com.minhvu.model.Employee;

public interface EmployeeDao {
	public List listAllUser();

	public void addUser(Employee employee);

	public void updateUser(Employee employee);

	public void delete(Employee employee);

	public Employee findUserById(Employee employee);
}
