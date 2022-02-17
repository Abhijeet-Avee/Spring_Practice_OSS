package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(path = "myapp")
public class HelloController {

	
	@GetMapping(path="stock/tyre/{qty}/{grade}")
	public ModelAndView hello6(@PathVariable(name = "qty") int qty, 
			@PathVariable(name = "grade") String grade) {
		System.out.println(qty);
		System.out.println(grade);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("qty", qty);
		return mv;
	}
	
	
	@GetMapping(path="foo5")
	public ModelAndView hello5(ModelAndView mv, HttpServletRequest req, HttpSession session) {
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("city"));
		mv.setViewName("hello");
		mv.addObject("key", "ymsli champs!");
		return mv;
	}
	
	//@RequestParam
	
	//foo4?username=raj&city=delhi
	@GetMapping(path="foo4")
	public ModelAndView hello4(ModelAndView mv,
			@RequestParam(name = "name") String name,
			@RequestParam(name="city") String city ) {
		System.out.println(name);
		System.out.println(city);
		mv.setViewName("hello");
		mv.addObject("key", "ymsli champs!");
		return mv;
	}
	
	
	
	
	//ModelAndView vs Model vs ModelMap
	
	

	@GetMapping(path="foo")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("hello");
		mv.addObject("key", "ymsli champs!");
		return mv;
	}
	
	@GetMapping(path="foousingmodel")
	public String helloUsingModel(Model mv) {
		
		mv.addAttribute("key", "ymsli champs! using model");
		return "mypage";
	}
	

	@GetMapping(path="foousingmodelmap")
	public String helloUsingModelMap(ModelMap modelMap) {
		
		modelMap.addAttribute("key", "ymsli champs! using model");
		return "mypage";
	}
	

	@GetMapping("foo2")
	public ModelAndView hello2(ModelAndView mv) {
		mv.setViewName("hello");
		mv.addObject("key", "ymsli champs 2!");
		return mv;
	}
	
}
