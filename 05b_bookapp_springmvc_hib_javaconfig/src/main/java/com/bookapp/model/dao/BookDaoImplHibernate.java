package com.bookapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookapp.exceptions.BookNotFoundException;

@Repository
@Primary
public class BookDaoImplHibernate implements BookDao {

	private SessionFactory sessionFactory;

	@Autowired
	public BookDaoImplHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("from Book",Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		getSession().persist(book);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
	}

	@Override
	public void updateBook(int id, Book book) {
		getSession().merge(book);
	}

	@Override
	public Book getBookById(int id) {
		Book book = getSession().get(Book.class, id);
		if(book == null) {
			throw new BookNotFoundException("book with id "+ id + "no found");
		}
		return book;
	}
	
}
