package com.verizon.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.model.Employee;
import com.verizon.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> listEmployeesAction(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	//For searching based on URL
	@GetMapping("/{emp_code}")
	public ResponseEntity<Employee> getEmployeeAction(@PathVariable("emp_code") int emp_code) {
		ResponseEntity<Employee> resp = null;
		Employee e = employeeService.getEmployeeById(emp_code);
		if (e == null)
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<Employee>(e, HttpStatus.OK);
		return resp;
	}
	
	//multiple param receiving GetMapping(/{param1}/{param2}/{param3}	
	//For deleting based on URL
	@DeleteMapping("/{emp_code}")
	public ResponseEntity<Void> deleteBookAction(@PathVariable("emp_code") int emp_code) {
		ResponseEntity<Void> resp = null;

		boolean isDeleted = employeeService.deleteEmployee(emp_code);
		if (!isDeleted)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(HttpStatus.OK);

		return resp;

	}
	
	@PostMapping
	public ResponseEntity<Employee> addBookAction(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;
		employee = employeeService.addEmployee(employee);
		if (employee != null)
			resp = new ResponseEntity<>(employee, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateBookAction(@RequestBody Employee employee) {
		ResponseEntity<Employee> resp = null;
		if (employeeService.getEmployeeById(employee.getEmp_code()) == null) {
			resp = new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else {
			employee = employeeService.updateEmployee(employee);
			if (employee != null)
				resp = new ResponseEntity<Employee>(employee, HttpStatus.OK);
			else
				resp = new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
