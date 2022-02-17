package com.bankapp.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
	
	private Logger logger= LoggerFactory.getLogger(AccountServiceImpl.class);
	private AccountDao dao;
	private SendSmsService smsService;
	
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	public void setSmsService(SendSmsService smsService) {
		this.smsService = smsService;
	}

	public AccountServiceImpl() {}

	public AccountServiceImpl(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Account> getAll() {
		return dao.getAll();
	}

	@Override
	public Account getById(int id) {
		return dao.getById(id);
	}

	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {
		
		long start= System.currentTimeMillis();
		
		Account fromAcc=dao.getById(fromAccId);
		Account toAcc=dao.getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		dao.update(fromAcc);
		dao.update(toAcc);
		if(smsService!=null)
		smsService.sendSms();
		System.out.println("fund is transfred...");
		
		long end= System.currentTimeMillis();
		logger.info("time taken : "+ (end-start));
		
	}
	public void addAccount(Account account) {
		long start= System.currentTimeMillis();
		dao.addAccount(account);

		long end= System.currentTimeMillis();
		logger.info("time taken to add record : "+ (end-start));
		
	}

}












