package com.bookstore.cassandra.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.bookstore.cassandra.rest.model.Book;
import com.bookstore.cassandra.utility.CassandraConnector;
import com.bookstore.cassandra.utility.MappingManagerFactory;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;

public class BookstoreCassandraRepository extends CassandraConnector {


	private static final Logger logger = Logger.getLogger(BookstoreCassandraRepository.class);
	
	
	public Book createBook(Book book) {
		//book.setPublishedOn(new Date());
		PreparedStatement bookInsertStatement = session.prepare("Insert into books(book_id,name,author,code,price,isbn,publisher,published_date)"+
		"values(:bookId,:name,:author,:code,:price,:isbn,:publisher,:publishedOn);");
		BoundStatement statement = new BoundStatement(bookInsertStatement).
				setUUID("bookId", UUID.randomUUID()).
				setString( "name", book.getName()).
				setString("author",book.getAuthor()).
				setString("code", book.getCode()).
				setString("price", book.getPrice()).
				setString("isbn",book.getIsbn()).
				setString("publisher",book.getPublisher()).
				setTimestamp("publishedOn",book.getPublishedOn());
				
		session.execute(statement);
		
		return book;
	}

	public List<Book> getBooks() {
		
		ResultSet set = session.execute("select * from books;");
		List<Book> books = new ArrayList<Book>();
		
		
		for(Row row:set){
			Book book = new Book();
			book.setAuthor(row.getString("author"));
			book.setCode(row.getString("code"));
			//book.setId(UUID.fromString(row.getString("book_id")));
			book.setId(row.getUUID("book_id"));
			book.setIsbn(row.getString("isbn"));
			book.setName(row.getString("name"));
			book.setPrice(row.getString("price"));
			book.setPublisher(row.getString("publisher"));
			book.setPublishedOn(row.getTimestamp("published_date"));
			books.add(book);
			book = null;
		}
		
		
		return books;
	}
	
	public Book updateBook(Book book){
		PreparedStatement bookUpdateStatement = session.prepare("update books set name=:name,author=:author,code=:code,price=:price,isbn=:isbn,publisher=:publisher,published_date=:publishedOn where book_id=:bookId");
		BoundStatement statement = new BoundStatement(bookUpdateStatement).
				setUUID("bookId", book.getId()).
				setString( "name", book.getName()).
				setString("author",book.getAuthor()).
				setString("code", book.getCode()).
				setString("price", book.getPrice()).
				setString("isbn",book.getIsbn()).
				setString("publisher",book.getPublisher()).
				setTimestamp("publishedOn",book.getPublishedOn());
		try{
			session.execute(statement);
		}
		catch(DriverException e){
			logger.info(e.getMessage().toUpperCase());
			return null;
		}
		return book;
	}
	
	
	public List<Book> getBooksByName(String bookName){
		
		ResultSet set = session.execute("select * from books where name='"+bookName+"';");
		
		List<Book> books = new ArrayList<Book>();
		
		
		for(Row row:set){
			Book book = new Book();
			book.setAuthor(row.getString("author"));
			book.setCode(row.getString("code"));
			//book.setId(UUID.fromString(row.getString("book_id")));
			book.setId(row.getUUID("book_id"));
			book.setIsbn(row.getString("isbn"));
			book.setName(row.getString("name"));
			book.setPrice(row.getString("price"));
			book.setPublisher(row.getString("publisher"));
			book.setPublishedOn(row.getTimestamp("published_date"));
			books.add(book);
			book = null;
		}
		
		return books;
	}

	public void deleteBook(String book) {
		PreparedStatement deleteBookStatement = session.prepare("delete from books where book_id=:bookId");
		//session.execute("delete * from books where bookId="+book.getId()+";");
		BoundStatement statement = new BoundStatement(deleteBookStatement).
				setUUID("bookId", UUID.fromString(book));
		session.execute(statement);
	}
	
	
}
