package com.verizon.dao;

public interface IQueryMapper {
	
	public static final String INS_EMPLOYEE_QRY=
			"INSERT INTO employee VALUES(?,?,?,?,?)";
	public static final String DEL_EMPLOYEE_QRY=
			"DELETE FROM employee WHERE emp_code=?";
	public static final String UPDATE_EMPLOYEE_QRY=
			"UPDATE employee SET emp_name=?,emp_basic=?,emp_hra=?,emp_department=? WHERE emp_code=?";
	public static final String GET_EMPLOYEE_QRY=
			"SELECT * FROM employee WHERE emp_code=?";
	public static final String GET_ALL_EMPLOYEES_QRY=
			"SELECT * FROM employee";

}
