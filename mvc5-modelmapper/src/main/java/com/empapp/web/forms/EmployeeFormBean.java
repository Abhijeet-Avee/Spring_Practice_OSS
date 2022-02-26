package com.empapp.web.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeFormBean {
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotNull
	@Min(value=10000, message= "min price should be more than 10000")
	@Max(value=100000, message = "max price should be less than 100000")
	private Double salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public EmployeeFormBean(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public EmployeeFormBean() {}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
