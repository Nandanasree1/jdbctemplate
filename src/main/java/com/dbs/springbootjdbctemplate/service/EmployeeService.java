package com.dbs.springbootjdbctemplate.service;

import java.util.List;
import java.util.Optional;

import com.dbs.springbootjdbctemplate.dto.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
    public Employee deleteEmployee(String empId);
    public Employee updateEmployee(String empId,Employee employee);
    public Optional<Employee> getEmployeeById(String id);
	public Optional<List<Employee>> getEmployeesByLastName(String emplastName);
	public Optional<Employee> getEmployeeeByLastName(String empId, String emplastName);
	public Optional<List<Employee>> getEmployees();
	public void deleteAll();
	
	

}

