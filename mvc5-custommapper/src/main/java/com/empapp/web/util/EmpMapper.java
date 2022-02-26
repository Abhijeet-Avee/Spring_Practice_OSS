package com.empapp.web.util;

import com.empapp.model.dao.Employee;
import com.empapp.web.forms.EmployeeFormBean;


public class EmpMapper {

	public static Employee convertToEmployee(EmployeeFormBean employeeForm) {
		Employee employee=new Employee();
		employee.setId(employeeForm.getId());
		employee.setName(employeeForm.getName());
		employee.setSalary(employeeForm.getSalary());
		return employee;
	}
	
	public static EmployeeFormBean convertToEmployeeForm(Employee employee) {
		EmployeeFormBean employeeForm=new EmployeeFormBean();
		employeeForm.setId(employee.getId());
		employeeForm.setName(employee.getName());
		employeeForm.setSalary(employee.getSalary());
		return employeeForm;
	}
	
}