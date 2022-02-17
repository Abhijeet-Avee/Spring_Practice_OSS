package com.empapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.empapp.model.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("allemps")
	public ModelAndView getAll(ModelAndView mv) {
		mv.addObject("employees", employeeService.getAll());
		mv.setViewName("allemps");
		return mv;
	}

}
