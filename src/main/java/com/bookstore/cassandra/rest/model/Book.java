package com.bookstore.cassandra.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;


import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

public class Book implements Serializable{
	
	private UUID id;
	private String name;
	private String code;
	private String price;
	private String author;
	private String isbn;
	private String publisher;
	private Date publishedOn;

	
	public UUID getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	
	public String getCode() {
		return code;
	}

	
	public String getPrice() {
		return price;
	}

	
	public String getAuthor() {
		return author;
	}

	
	public String getIsbn() {
		return isbn;
	}

	
	public String getPublisher() {
		return publisher;
	}
	
	
	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setId() {
		id = UUID.randomUUID();
	}
	
	public void setId(UUID uuid){
		id = uuid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

}
