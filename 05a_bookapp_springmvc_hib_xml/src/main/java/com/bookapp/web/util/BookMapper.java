package com.bookapp.web.util;

import com.bookapp.model.dao.Book;
import com.bookapp.web.forms.BookFormBean;

public class BookMapper {
	
	public static Book convertToBook(BookFormBean bookForm) {
		Book book = new Book();
		book.setId(bookForm.getId());
		book.setIsbn(bookForm.getIsbn());
		book.setTitle(bookForm.getTitle());
		book.setAuthor(bookForm.getAuthor());
		book.setPrice(bookForm.getPrice());
		return book;
	}
	
	public static BookFormBean convertToBookForm(Book book) {
		BookFormBean bookFormBean = new BookFormBean();
		bookFormBean.setId(book.getId());
		bookFormBean.setIsbn(book.getIsbn());
		bookFormBean.setTitle(book.getTitle());
		bookFormBean.setAuthor(book.getAuthor());
		bookFormBean.setPrice(book.getPrice());
		return bookFormBean;
	}
	
}
