package com.verizon.service;

import java.util.List;

import com.verizon.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeeById(int emp_code);
	boolean deleteEmployee(int emp_code);
	List<Employee> getAllEmployee();

}
