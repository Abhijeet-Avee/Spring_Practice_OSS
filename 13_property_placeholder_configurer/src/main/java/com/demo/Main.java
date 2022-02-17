package com.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx=
				new ClassPathXmlApplicationContext("lifecycle.xml");
		
		Account account=ctx.getBean("acc", Account.class);
		System.out.println(account);
		
	}
}