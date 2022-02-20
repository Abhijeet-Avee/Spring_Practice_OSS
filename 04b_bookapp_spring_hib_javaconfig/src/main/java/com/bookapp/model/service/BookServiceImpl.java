package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;

@Service(value="bookService")
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BookServiceImpl implements BookService{

	private BookDao dao;
	
	@Autowired
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false)
	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false)
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false)
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
