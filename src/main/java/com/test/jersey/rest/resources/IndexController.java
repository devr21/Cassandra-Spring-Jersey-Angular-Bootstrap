package com.test.jersey.rest.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Path("/")
public class IndexController {

	@Context
	UriInfo uriInfo;
	
	  @GET
	  @Path("/index")
	  @Produces(MediaType.TEXT_HTML )
	    public Response getIndexPage() {
		  	
	        return Response.ok().entity(new Viewable("/bookManagement",null)).build();
	    }

	  @GET
	  @Path("/home")
	  @Produces("text/html")
	  public Response getThisPage(){
		  return Response.status(200).entity("Another page").build();
	  }
	  
}