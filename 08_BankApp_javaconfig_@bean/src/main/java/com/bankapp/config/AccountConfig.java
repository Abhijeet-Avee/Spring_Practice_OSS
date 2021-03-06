package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.AccountDaoImpl;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountServiceImpl;
import com.bankapp.model.service.SendSmsService;
import com.bankapp.model.service.SendSmsServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
public class AccountConfig {
	
	@Bean(name="accountService")
	public AccountService getAccountService(AccountDao dao, SendSmsService sms) {
		AccountServiceImpl accountService = new AccountServiceImpl();
//		accountService.setDao(getAccountDao());
//		accountService.setSmsService(sendSmsService());
		accountService.setDao(dao);
		accountService.setSmsService(sms);
		return accountService;
	}
	
	@Bean(name="accountDao")
	public AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
	@Lazy(value=true)
	@Scope("singleton")
	@Bean(name = "smsService")
	public SendSmsService sendSmsService() {
		return new SendSmsServiceImpl();
	}
}
