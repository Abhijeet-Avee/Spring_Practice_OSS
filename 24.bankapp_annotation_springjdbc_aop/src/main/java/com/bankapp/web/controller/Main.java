package com.bankapp.web.controller;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bank.xml");
		
		AccountService accountService=(AccountService) ctx.getBean("accountService");
		//List<Account> getAll= accountService.getAll();
		//getAll.forEach(a-> System.out.println(a));
//		Account account1=new Account("umesh", 30000);
//		accountService.addAccount(account1);
//		accountService.transfer(1, 2, 100);
		
		Account account = accountService.getById(8);
		account.setBalance(account.getBalance()+10000);
		
		
	}

}