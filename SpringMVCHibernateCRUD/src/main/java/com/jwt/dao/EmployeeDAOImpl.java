package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.*;;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		
		
	}
		
	/*
	 * public void validateUser(Employee employee) { // String sql =
	 * "select * from users where fname='" + employee.getFname() +
	 * "' and password='" + employee.getPassword() //+ "'"; return (Employee)
	 * sessionFactory.getCurrentSession().get( Employee.class, empid);
	 * 
	 * 
	 * // List<User> users = jdbcTemplate.query(sql, new UserMapper()); // return
	 * users.size() > 0 ? users.get(0) : null;
	 * 
	 * }
	 */
		

	

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}