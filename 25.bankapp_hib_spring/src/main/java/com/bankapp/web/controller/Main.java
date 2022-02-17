package com.bankapp.web.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=(AccountService) ctx.getBean("accountService");
		
		//System.out.println(account);
		Account a1=new Account("ravi", 20000);
		Account a2=new Account("sachin", 40000);
		
		//accountService.addAccount(a1);
		//accountService.addAccount(a2);
		
		
		accountService.transfer(2, 1, 1000);
		
	}

}
