package com.verizon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.verizon.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		
		employee.setEmp_name(rs.getString(1));
		employee.setEmp_code(rs.getInt(2));  		//This line is getting the value in the first row of the database and is saving it in the book
		employee.setEmp_basic(rs.getDouble(3));
		employee.setEmp_hra(rs.getDouble(4));
		employee.setEmp_department(rs.getString(5));
		
		return employee;
	}

}
