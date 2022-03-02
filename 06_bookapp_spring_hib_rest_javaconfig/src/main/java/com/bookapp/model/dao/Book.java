package com.bookapp.model.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booktable")
public class Book {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String isbn;
		private String title;
		private String author;
		private double price;
		
		public Book() {

		}
		public Book(int id, String isbn, String title, String author, double price) {
			super();
			this.id = id;
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.price = price;
		}
		
		public Book(String isbn, String title, String author, double price) {
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.price = price;
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Book [id=").append(id).append(", isbn=").append(isbn).append(", title=").append(title)
					.append(", author=").append(author).append(", price=").append(price).append("]");
			return builder.toString();
		}
		
}