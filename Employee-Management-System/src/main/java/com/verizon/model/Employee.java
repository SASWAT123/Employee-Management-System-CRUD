package com.verizon.model;

public class Employee {
	
	private String emp_name;
	private int emp_code;
	private double emp_basic;
	private double emp_hra;
	private String emp_department;
	
	public Employee() {
		
	}

	public Employee(String emp_name, int emp_code, double emp_basic, double emp_hra, String emp_department) {
		this.emp_name = emp_name;
		this.emp_code = emp_code;
		this.emp_basic = emp_basic;
		this.emp_hra = emp_hra;
		this.emp_department = emp_department;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public double getEmp_basic() {
		return emp_basic;
	}

	public void setEmp_basic(double emp_basic) {
		this.emp_basic = emp_basic;
	}

	public double getEmp_hra() {
		return emp_hra;
	}

	public void setEmp_hra(double emp_hra) {
		this.emp_hra = emp_hra;
	}

	public String getEmp_department() {
		return emp_department;
	}

	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}
		
}
