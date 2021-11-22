package com.dbs.springbootjdbctemplate.service;

import java.util.List;

import java.util.Optional;

import com.dbs.springbootjdbctemplate.dto.Department;



public interface DepartmentService {
	public Department createDepartment(Department department);
    public Department deleteDepartment(String deptId);
    public Department updateDepartment(String deptId,Department department);
    public Optional<Department> getDepartmentById(String empId);
	
	
}
