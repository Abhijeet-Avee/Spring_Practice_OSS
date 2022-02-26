package com.empapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.model.dao.Employee;
import com.empapp.model.service.EmployeeService;

//@RestController // = @Controller + @ResponseBody //ResponseBody triggers the parser to convert java object into json
//@RequestMapping(path = "api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping(path = "employees/{id}")
	public Employee getEmployee(@PathVariable(name = "id") int id) {
		return employeeService.getById(id);
	}
	
	//Post
	@PostMapping(path = "employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	//Update
	@PutMapping(path = "employees/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") int id,
			@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	//Delete
	@DeleteMapping(path = "employees/{id}")
	public Employee deleteEmployee(@PathVariable(name = "id") int id) {
		return employeeService.deleteEmployee(id);
	}
}
