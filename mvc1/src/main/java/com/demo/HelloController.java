package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="myapp")
public class HelloController {
	
	//@RequestParam
	//hello4?name=yash&city=raxaul
	@GetMapping("hello4")
	public ModelAndView hello4(ModelAndView mv,
				@RequestParam(name = "name") String name,
				@RequestParam(name = "city") String city) {
		System.out.println(name);
		System.out.println(city);
		mv.setViewName("hellojsp");		//jsp page to redirect
		mv.addObject("key",name+" "+city);
		return mv;
	}
	
	@GetMapping(path="stock/tyre/{count}/{company}")
	public ModelAndView hello8(ModelAndView mv,
			@PathVariable("count") int count,
			@PathVariable("company") String cmp) {
		System.out.println(count);
		System.out.println(cmp);
		mv.setViewName("hellojsp");		//jsp page to redirect
		mv.addObject("key",count + " "+ cmp);
		return mv;
	}
	
	@GetMapping("hello") //url mapping
	//complete path - /myapp/hello
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("hellojsp");		//jsp page to redirect
		mv.addObject("key","spring mvc");
		return mv;
	}
	
	@GetMapping("hellomodel")	//url mapping
	public String helloModel(Model m) {
		m.addAttribute("key","spring mvc by model");
		return "hellomodeljsp"; //jsp page to redirect
	}
	
	@GetMapping("hellomodelmap")
	public String helloModelMap(ModelMap mm) {
		mm.addAttribute("key","spring mvc by modelmap");
		return "hellomodelmapjsp";
	}
}
