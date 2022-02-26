package com.empapp.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.empapp.model.exceptions.EmployeeNotFoundException;

@Repository
@Primary
public class EmployeeDaoImpl implements EmployeeDao {

	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		 getSession().save(employee);
		 return employee;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Employee employeeToDelete=getById(id);
		getSession().remove(employeeToDelete);
		return employeeToDelete;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee employeeToUpdate=getById(id);
		employeeToUpdate.setSalary(employee.getSalary());
		getSession().merge(employeeToUpdate);
		return employeeToUpdate;
	}

	@Override
	public List<Employee> getAll() {
		return getSession().createQuery("from Employee", Employee.class).getResultList();
	}

	@Override
	public Employee getById(int id) {
		Employee employee= getSession().get(Employee.class, id);
		if(employee==null) {
			throw new EmployeeNotFoundException("emp with id "+ id +" is not found");
		}
		return employee;
	}

}
