package com.bankapp.model.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bankapp.model.service.exceptions.MyAppAccountNotFoundException;

@Repository
@Primary
public class AccountDaoImplHibernate implements AccountDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public AccountDaoImplHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//helper method 
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Account> getAll() {
		return getSession().createQuery("from Account", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		
		Account account=getSession().get(Account.class, id);
		
		if(account==null) {
			throw new MyAppAccountNotFoundException("account with id "+ id +" is not found");	
		}
		return account;
	}

	@Override
	public void update(Account account) {
		getSession().merge(account);
	}

	@Override
	public void addAccount(Account account) {
		getSession().persist(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account objectToDelete= getById(id);
		getSession().delete(objectToDelete);
	}
}
