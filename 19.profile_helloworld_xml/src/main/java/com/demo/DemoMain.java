package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {

		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("demo.xml");
		
		
		Foo foo=ctx.getBean("foo", Foo.class);
		System.out.println(foo.getFooValue());
		
	}
}
