package com.bankapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoImplJdbc implements AccountDao {

	private DataSource dataSource;

	public AccountDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAll() {

		return null;
	}

	@Override
	public void update(Account account) {

	}

	@Override
	public Account getById(int id) {

		return null;
	}

	@Override
	public void addAccount(Account account) {
		

		String sql = "INSERT INTO account (name, balance ) VALUES ( ?, ?)";
		Connection connection=null;
		try {
			 connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, account.getName());
			ps.setDouble(2, account.getBalance());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}

	}

}
