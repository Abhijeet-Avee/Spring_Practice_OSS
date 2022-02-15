package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;

//<bean id="accountService" class="com.bankapp.model.service.AccountServiceImpl">
@Service(value="accountService")
public class AccountServiceImpl implements AccountService {

	private AccountDao dao;

	private SendSmsService smsService;
	
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}
//<property name="smsService" ref="smsService"/>
	@Autowired
	public void setSmsService(SendSmsService smsService) {
		this.smsService = smsService;
	}

	public AccountServiceImpl() {}

//	<constructor-arg index="0" ref="dao"/>
	@Autowired
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
		
		Account fromAcc=dao.getById(fromAccId);
		Account toAcc=dao.getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		
		dao.update(fromAcc);
		dao.update(toAcc);
		if(smsService!=null)
		smsService.sendSms();
		System.out.println("fund is transfred...");
		
	}

}











