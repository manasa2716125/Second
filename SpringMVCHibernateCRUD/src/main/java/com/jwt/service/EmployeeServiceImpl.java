package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployeeDAO;
import com.jwt.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public Employee getEmployee(int empid) {
		return employeeDAO.getEmployee(empid);
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Employee validateLogin(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateLogin(int employeeId) {
	}
	/*
	 * @Override public Employee validateStudentCredential(String name, String
	 * password) { Employee employee =
	 * getEmployeeDAO().getStudentDetailsByNameAndPassword(name, password); return
	 * employee; }
	 */

	@Override
	public Employee validateStudentCredential(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
	


