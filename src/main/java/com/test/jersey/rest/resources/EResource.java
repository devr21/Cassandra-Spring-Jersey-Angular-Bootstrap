package com.test.jersey.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/resource")
public class EResource {

	@GET
	@Path("/")
	@Produces("text/html")
	public Response getPage(){
		
		String str = "DATA ON PAGE";
		return Response.status(200).entity(str).build();
		
	}
	
}
