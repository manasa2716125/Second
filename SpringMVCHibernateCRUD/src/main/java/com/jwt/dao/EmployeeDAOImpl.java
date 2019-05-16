package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.jwt.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

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
	
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Employee getStudentDetailsByNameAndPassword(String name,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Employee.class);
		detachedCriteria.add(Restrictions.eq("name", name));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<Employee> findByCriteria = (List<Employee>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}*/

	@Override
	public boolean saveStudent(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getStudentDetailsByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Employee getStudentDetailsByEmailAndPassword(String name,
	 * String password) { // TODO Auto-generated method stub return null; }
	 */
}