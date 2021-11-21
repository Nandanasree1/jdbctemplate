package com.dbs.springbootjdbctemplate;



import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.service.EmployeeService;



@SpringBootApplication
public class SpringbootJdbctemplateApplication {



public static void main(String[] args) {
ApplicationContext applicationContext=SpringApplication.run(SpringbootJdbctemplateApplication.class, args);
DataSource dataSource=applicationContext.getBean(DataSource.class);
System.out.println(dataSource!=null);
EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
Employee employee = new Employee("1238","nandana","sree","tiupathi",100.0f);
Employee employee2 = employeeService.createEmployee(employee);
//System.out.println(employee2);
Optional<List<Employee>> optional2 = employeeService.getEmployeesByLastName("sree");
if(optional2.isPresent()) {
	System.out.println(optional2.get());
}
else {
	System.out.println("record not found");
}
}
}