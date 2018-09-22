package com.verizon.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.verizon.model.Employee;

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDaoJdbcImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		int count = jdbcTemplate.update(IQueryMapper.INS_EMPLOYEE_QRY,
				employee.getEmp_name(),
				employee.getEmp_code(),
				employee.getEmp_basic(),
				employee.getEmp_hra(),
				employee.getEmp_department()
				);
		if(count<1) {
			employee=null;
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int count = jdbcTemplate.update(IQueryMapper.UPDATE_EMPLOYEE_QRY,
				employee.getEmp_name(),
				employee.getEmp_basic(),
				employee.getEmp_hra(),
				employee.getEmp_department(),
				employee.getEmp_code()
				);
		if(count<1) {
			employee=null;
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int emp_code) {
		List<Employee> employees = jdbcTemplate.query(
				IQueryMapper.GET_EMPLOYEE_QRY,
				new Object[] {emp_code},
				new EmployeeRowMapper());    //The rowmapper is going to retrieve a list for us using EmployeeRowMapper
		
		Employee employee = null;
		if(employees!=null && employees.size()==1) {
			employee = employees.get(0);
		}
		return employee;
	}

	@Override
	public boolean deleteEmployee(int emp_code) {
		boolean isDeleted=false;
		
		int count = jdbcTemplate.update(
				IQueryMapper.DEL_EMPLOYEE_QRY, emp_code);
		
		if(count>=1) {
			isDeleted=true;
		}
		
		return isDeleted;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = jdbcTemplate.query(
				IQueryMapper.GET_ALL_EMPLOYEES_QRY,
				new EmployeeRowMapper());    //The rowmapper is going to retrieve a list for us
		
		return employees;
	}

}
