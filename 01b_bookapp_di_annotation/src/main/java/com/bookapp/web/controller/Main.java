package com.bookapp.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDaoImpl;
import com.bookapp.model.service.BookService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("book.xml");
		
		BookService service = (BookService) ctx.getBean("bookService");
		
		for(Book book : service.getAllBooks()) {
			System.out.println(book);
		}
	}
}
