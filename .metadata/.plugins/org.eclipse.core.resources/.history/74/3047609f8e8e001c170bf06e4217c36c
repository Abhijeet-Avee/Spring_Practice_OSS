package com.bankapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.model.service.AccountService;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bank.xml");
		
		AccountService accountService=(AccountService) ctx.getBean("accountService");
		accountService.transfer(1, 2, 100);
	}

}