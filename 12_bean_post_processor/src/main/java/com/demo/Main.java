package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=
				new ClassPathXmlApplicationContext("lifecycle.xml");
		ctx.registerShutdownHook();
	
		Foo foo=ctx.getBean("foo", Foo.class);
		foo.doWork();
		
	}
}