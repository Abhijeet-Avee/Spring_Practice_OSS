package com.empapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empapp.model.dao.Employee;
import com.empapp.model.dao.EmployeeDao;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		return employeeDao.updateEmployee(id, employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

}
