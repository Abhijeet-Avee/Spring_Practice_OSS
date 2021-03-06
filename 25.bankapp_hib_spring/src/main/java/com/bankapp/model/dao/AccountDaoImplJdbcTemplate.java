package com.bankapp.model.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//@Repository
//@Primary
public class AccountDaoImplJdbcTemplate implements AccountDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		String sql = "select * from account";
		//return jdbcTemplate.query(sql,(rs, rowNum)-> new Account(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		return jdbcTemplate.query(sql, new AccountRowMapper()); 
	}

	@Override
	public void update(Account account) {
		String sql = "update account set balance =? where id=?";
		jdbcTemplate.update(sql, new Object[] {account.getBalance(),account.getId()});
	}

	@Override
	public Account getById(int id) {
		//Using BeanPropertyRowMapper
		String sql = "select * from account where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public void addAccount(Account account) {
		String sql = "INSERT INTO account (name, balance ) VALUES ( ?, ?)";
		jdbcTemplate.update(sql, new Object[] {account.getName(),account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		String sql = "delete from account where id=?";
		jdbcTemplate.update(sql,id);
	}	

}
