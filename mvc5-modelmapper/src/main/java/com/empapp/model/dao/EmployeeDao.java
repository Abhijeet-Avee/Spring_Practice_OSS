package com.empapp.model.dao;

import java.util.List;


public interface EmployeeDao {
	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public Employee updateEmployee(int id , Employee employee);
	public List<Employee> getAll();
	public Employee getById(int id);
}
