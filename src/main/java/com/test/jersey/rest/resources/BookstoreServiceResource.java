package com.test.jersey.rest.resources;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.springframework.stereotype.Component;


import org.springframework.web.util.UriComponentsBuilder;

import com.bookstore.cassandra.rest.model.Book;
import com.bookstore.cassandra.rest.service.BookstoreService;


@Component
@Path("/bookservice")
public class BookstoreServiceResource {

	/*@Inject 
	private BookstoreService bookService;*/
	
	@POST
	@Path("/book")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createBook( Book book){
		/*bookService.createBook(book);*/
        
		return Response.ok().entity(book).build();
	}
	
	@GET
	@Path("/getBooks")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getBooks(){
		/*Collection<Book> books = bookService.getBooks();*/
		
		/*return Response.ok().entity(books).build();*/
		return Response.ok().build();
	}
	
	@PUT
	@Path("/book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response editBook(Book book){
		/*return Response.ok().entity(bookService.editBook(book)).build();*/
		return Response.ok().build();
	}
	
	@GET
	@Path("/book/{bookName}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getBookByName(@PathParam("bookName") String bookName){
		/*return Response.ok().entity(bookService.getBooksByName(bookName)).build();*/
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/book/{id}")
	public Response deleteBook(@PathParam("id") String id){
		
		/*bookService.deleteBook(id);*/
		
		return Response.ok().build();
	}
	
	
}
