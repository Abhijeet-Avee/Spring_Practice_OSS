package com.bookapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookDao dao;

	@Autowired
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	@Override
	public Book updateBook(int id, Book book) {
		return dao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}
