package com.minhvu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minhvu.model.Employee;
import com.minhvu.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/user/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Employee>> listAllUser() {
		List<Employee> list = employeeService.listAllUser();

		if (list.size() == 0) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/add/", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Void> add(@RequestBody Employee employee) {
		employeeService.addUser(employee);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeService.updateUser(employee);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeService.delete(employee);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}
}