package com.bookapp.web.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookFormBean {
	
	private Integer id;
	@NotEmpty
	private String isbn;
	@NotEmpty
	private String title;
	@NotEmpty
	private String author;
	@NotNull
	private Double price;
	
	public BookFormBean() {
		super();
	}

	public BookFormBean(String isbn,String title,String author,Double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookFormBean [id=").append(id).append(", isbn=").append(isbn).append(", title=").append(title)
				.append(", author=").append(author).append(", price=").append(price).append("]");
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
