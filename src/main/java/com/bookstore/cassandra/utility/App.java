package com.bookstore.cassandra.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.bookstore.cassandra.rest.model.Book;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class App {

	public static void main(String[] args) {
		
		/*Book book = new Book();
		book.setId();
		book.setAuthor("Sidney Sheldon");
		book.setCode("TDC");
		book.setIsbn("123");
		book.setName("The Doomsday Conspiracy");
		book.setPrice("542");
		book.setPublisher("Harper Collins");
		book.setPublishedOn(new Date());*/
		
		Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
		Session session = cluster.connect();
		/*MappingManager manager = new MappingManager(session);
		Mapper<Book> mapper = manager.mapper(Book.class);
		mapper.save(book);*/
		
		/*session.execute("Insert into myks.books(book_id,name,code,price,author,isbn,publisher) values(now(),'The Doomsday Conspiracy','TDC','542','Sidney Sheldon','123','Harper Collins')");*/
		
		/*ResultSet set = session.execute("Select * from myks.books");
		List<Book> books = new ArrayList<Book>();
		Date date ;
		for(Row row:set){
			date = row.getTimestamp("published_date");
			System.out.println(date);
		}*/
		
		session.execute("update myks.books set code='this' where isbn='142'");
		
		session.close();
		cluster.close();
	}
	
}
