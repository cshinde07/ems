package com.mtree.ems.service;

import java.util.List;

import com.mtree.ems.entity.Employee;

public interface EmployeeService extends Service<Employee> {
	
	public List<Employee> findAllEmployees();

}