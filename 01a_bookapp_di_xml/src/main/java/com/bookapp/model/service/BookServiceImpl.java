package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dao.BookDaoImpl;

public class BookServiceImpl implements BookService{

	private BookDao dao;
	
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
