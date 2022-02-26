package com.empapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController // = @Controller + @ResponseBody //ResponseBody triggers the parser to convert java object into json
@RequestMapping(path = "api")
public class EmployeeRestController2 {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController2(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
	}
	
	@GetMapping(path = "employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
	}
	
	//Post
	@PostMapping(path = "employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
	}
	
	//Update
	@PutMapping(path = "employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") int id,
			@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.updateEmployee(id, employee));
	}
	
	//Delete
	@DeleteMapping(path = "employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable(name = "id") int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
