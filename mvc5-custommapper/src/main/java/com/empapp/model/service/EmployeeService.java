package com.empapp.model.service;

import java.util.List;

import com.empapp.model.dao.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public Employee updateEmployee(int id , Employee employee);
	public List<Employee> getAll();
	public Employee getById(int id);
}
