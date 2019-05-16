package com.jwt.service;

import java.util.List;

import com.jwt.model.Employee;
//import com.mccoy.model.Student;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);
	
	public  Employee validateLogin(String name,	String password);
	//public abstract boolean registerStudent(Employee employee);

	public void validateLogin(int employeeId);
	
	
	public interface StudentService {
		public abstract Employee validateStudentCredential(String name,	String password);
		public abstract boolean registerStudent(Employee employee);
	}


	Employee validateStudentCredential(String name, String password);
	
}
