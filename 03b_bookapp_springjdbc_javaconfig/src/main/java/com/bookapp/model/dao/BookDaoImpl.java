package com.bookapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="dao")
public class BookDaoImpl implements BookDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getAllBooks() {
		String sql = "select * from books";
		return jdbcTemplate.query(sql, new BookRowMapper());
	}

	@Override
	public Book addBook(Book book) {
		String sql = "insert into books(isbn,title,author,price) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice()});
		return book;
	}

	@Override
	public void deleteBook(int id) {
		String sql = "delete from books where id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void updateBook(int id, Book book) {
		String sql = "update books set isbn =?,title=?,author=?,price=? where id=?";
		jdbcTemplate.update(sql, new Object[] {book.getIsbn(),book.getTitle(),book.getAuthor(),book.getPrice(),book.getId()});
	}

	@Override
	public Book getBookById(int id) {
		String sql = "select * from books where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class));
	}
	
}
