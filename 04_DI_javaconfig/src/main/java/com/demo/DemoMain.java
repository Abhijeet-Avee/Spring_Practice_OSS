package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class DemoMain {

	public static void main(String[] args) {
		
		//BeanFactory ctx=new XmlBeanFactory(new ClassPathResource("demo1.xml"));
		
	//ApplicationContext ctx=new ClassPathXmlApplicationContext("spring_config.xml");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Car car=ctx.getBean("car", Car.class);
		car.move();
				
	}
}