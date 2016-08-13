package com.bookstore.cassandra.repository;

import java.util.List;

import com.bookstore.cassandra.rest.model.Book;

public interface BookstoreRepository {

	void init();
	Book createBook(Book book);
	List<Book> getBooks();
	Book updateBook(Book book);
	List<Book> getBooksByName(String bookName);
	void deleteBook(String book);
	void destroy();
}
