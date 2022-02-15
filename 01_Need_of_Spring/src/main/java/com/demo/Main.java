package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		
		Car car =ctx.getBean("car", Car.class);
		Car car2 =ctx.getBean("car", Car.class);
		
		car.move();
		
		System.out.println(car.hashCode());
		System.out.println(car2.hashCode());
		//With the help of 
//		Tyre tyre=new CeatTyre();
//		Engine engine=new V8Engine();
//		
//		Car car=new Car(tyre, engine);
//		
//		car.move();
	}

}