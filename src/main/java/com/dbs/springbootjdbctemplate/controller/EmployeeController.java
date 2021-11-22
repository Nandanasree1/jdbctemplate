package com.dbs.springbootjdbctemplate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.service.EmployeeService;





@RestController
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@PostMapping("/create")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
	    Optional optional = employeeService.getEmployeeById(employee.getEmpId());
	    if(optional.isPresent()) {
	    	System.out.println(optional.get());
	    	Map<String, String> map = new HashMap<>();
	    	map.put("message", "record already exists");
	    	return ResponseEntity.status(400).body("map");
	    }
		Employee employee2 = employeeService.createEmployee(employee);
		if(employee2!=null)
		return ResponseEntity.status(201).body(employee);
		else
   
			return ResponseEntity.status(400).body("details are not proper");
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) {
		Optional<Employee> optional = employeeService.getEmployeeById(id);
		if(optional.isPresent())
			return ResponseEntity.status(200).body(optional.get());
		else
		return ResponseEntity.noContent().build();
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id){
		Employee employee = employeeService.deleteEmployee(id);
		
		if(employee!=null)
			return ResponseEntity.status(204).body("record deleted successfully");
			
		else
		 	return ResponseEntity.status(404).body("record not found");
	}
	@DeleteMapping
	public void deleteAll() {
		employeeService.deleteAll();
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees(){
		Optional<List<Employee>> optional = employeeService.getEmployees();
		if(optional.isPresent())
			return ResponseEntity.status(200).body(optional.get());
		else
		return ResponseEntity.noContent().build();
		
	}
		
	

}
