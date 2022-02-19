package com.bankapp.model.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//@Repository
//@Primary
public class AccountDaoImplJdbc implements AccountDao {

	private DataSource dataSource;

	public AccountDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAll() {
		List<Account> allAccounts=new ArrayList<>();
		
		String sql = "select * from account";
		Connection connection=null;
		try {
			 connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery(sql);
			while(rs.next()) {
				Account account= new Account
						(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				allAccounts.add(account);
			}
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
		return allAccounts;
	}

	@Override
	public void update(Account account) {
		String sql = "update account set balance =? where id=?";
		Connection connection=null;
		try {
			 connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getId());
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

	@Override
	public Account getById(int id) {
		Account account=null;
		String sql = "select * from account where id=?";
		Connection connection=null;
		try {
			 connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(sql);
			while(rs.next()) {
				account= new Account
						(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			}
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
		return account;
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

	@Override
	public void deleteAccount(int id) {
		String sql = "delete from account where id=?";
		Connection connection=null;
		try {
			 connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
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
