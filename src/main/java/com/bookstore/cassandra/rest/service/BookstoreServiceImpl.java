package com.bookstore.cassandra.rest.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.cassandra.repository.BookstoreRepository;
import com.bookstore.cassandra.rest.model.Book;

public class BookstoreServiceImpl implements BookstoreService{

	
	@Inject BookstoreRepository repository;
	
	public Book createBook(Book book) {
		return repository.createBook(book);
		
	}

	public Book editBook(Book book) {
		return repository.updateBook(book);
		
	}

	public void deleteBook(String book) {
		repository.deleteBook(book);
		
	}

	public List<Book> getBooksByName(String bookName) {
		
		return repository.getBooksByName(bookName);
	}

	public List<Book> getBooks() {
		
		return repository.getBooks();
	}

	
	
	
	
}
