package com.empapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.empapp.model.dao.Employee;
import com.empapp.model.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// --Add Employee---
	@GetMapping("addemp")
	public String addGet(ModelMap map) {
		//trying to attach blank object on form bean with jsp page
		map.addAttribute("emp", new Employee());
		return "empform";
	}

	// --Update Employee
	@GetMapping("updateemp")
	public String updateGet(ModelMap map, @RequestParam(name = "id") Integer id) {
		map.addAttribute("emp", employeeService.getById(id));
		return "empformupdate";
	}

	//--- Post add/update---
	@PostMapping("addupdateemp")
	//fetching object from form bean
	public String addPost(@Valid
			@ModelAttribute(name = "emp") Employee emp,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "empform";
		}else {
			if (emp.getId() == null)
				employeeService.addEmployee(emp);
			else
				employeeService.updateEmployee(emp.getId(), emp);
			return "redirect:allemps"; // response.sendRedirect
		}
	}

	// --Delete Employee
	@GetMapping("delemp")
	public String delEmp(@RequestParam(name = "id") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:allemps";
	}

	// ---Show all employees
	@GetMapping("allemps")
	public ModelAndView getAll(ModelAndView mv) {
		mv.addObject("employees", employeeService.getAll());
		mv.setViewName("allemps");
		return mv;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:allemps";
	}
}
