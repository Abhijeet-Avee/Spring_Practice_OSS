package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		
		School school=ctx.getBean("sch", School.class);
		school.print();
		/*
		 * Triangle triangle=ctx.getBean("tri" ,Triangle.class);
		 * triangle.printTriangle();
		 */
		//Shape shape=ctx.getBean("shape", Shape.class);
		//shape.printShape();
		//CountryWithMap country=ctx.getBean("c", CountryWithMap.class);
		//System.out.println(country);
	}
}