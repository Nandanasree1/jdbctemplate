package com.dbs.springbootjdbctemplate.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository employeeRepository;
@Override
public Employee createEmployee(Employee employee) {
// TODO Auto-generated method stub
return employeeRepository.save(employee);
} @Override
public Employee deleteEmployee(String empId) {
    return null;
// TODO Auto-generated method stub
} @Override
public Employee updateEmployee(String empId, Employee employee) {
// TODO Auto-generated method stub
    return null;
} 
public Optional<Employee> getEmployeeById(String empId) {
// TODO Auto-generated method stub
    
return employeeRepository.findById(empId);
} @Override
public Optional<List<Employee>> getEmployees() {
    List<Employee> employees=employeeRepository.findAll();
    if(employees.isEmpty()) {
        return Optional.empty();
    }
// TODO Auto-generated method stub
    else{return Optional.of(employees);
    }
}
public Optional<List<Employee>> getEmployeesByLastName(String empLastName){
    return employeeRepository.findByEmpLastName(empLastName);
}


@Override
public Optional<Employee> getEmployeeeByLastName(String empId, String emplastName) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	employeeRepository.deleteAll();
	
}

}