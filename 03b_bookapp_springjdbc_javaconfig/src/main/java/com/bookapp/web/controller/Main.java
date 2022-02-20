package com.bookapp.web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.config.BookConfig;
import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =  new AnnotationConfigApplicationContext(BookConfig.class);
		
		BookService service = (BookService) ctx.getBean("bookService");
		
		for(Book book : service.getAllBooks()) {
			System.out.println(book);
		}
	}
}
