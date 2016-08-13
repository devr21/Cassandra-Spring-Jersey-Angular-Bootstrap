package com.bookstore.cassandra.rest.service;

import java.util.List;

import com.bookstore.cassandra.rest.model.Book;

public interface BookstoreService {

public Book createBook(Book book);
	
	public Book editBook(Book book);
	
	public void deleteBook(String id);
	
	public List<Book> getBooksByName(String bookName);
	List<Book> getBooks();
}
