package com.bookapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

@RestController
@RequestMapping(path="api")
public class BookRestController {
	
	private BookService bookService;
	
	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(path = "books", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}
	
	@GetMapping(path = "books/{id}")
	public ResponseEntity<Book> getBooks(@PathVariable(name = "id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}
	
	//Post
	@PostMapping(path = "books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
	}
	
	//Update
	@PutMapping(path = "books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(name = "id") int id,
			@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookService.updateBook(id, book));
	}
	
	//Delete
	@DeleteMapping(path = "employees/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable(name = "id") int id) {
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
