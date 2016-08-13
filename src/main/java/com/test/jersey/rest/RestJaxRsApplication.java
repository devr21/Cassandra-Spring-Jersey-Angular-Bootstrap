package com.test.jersey.rest;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.bookstore.cassandra.utility.CustomMessageBodyWriter;
import com.test.jersey.rest.resources.IndexController;

public class RestJaxRsApplication extends ResourceConfig{

public RestJaxRsApplication() {
		
        packages("com.test.jersey.rest");
        
//		// register application resources
//		register(PodcastsResource.class);
//		register(PodcastLegacyResource.class);
//
//		// register filters
//		register(RequestContextFilter.class);
//		register(LoggingResponseFilter.class);
//		register(CORSResponseFilter.class);
//
//		// register exception mappers
//		register(GenericExceptionMapper.class);
//		register(AppExceptionMapper.class);
//      register(CustomReasonPhraseExceptionMapper.class);
//		register(NotFoundExceptionMapper.class);
//
//		// register features
//		register(JacksonFeature.class);
        
            /*register(JspMvcFeature.class);
            property(JspMvcFeature.TEMPLATES_BASE_PATH, "/WEB-INF/views");*/
            register(IndexController.class);
            register(CustomMessageBodyWriter.class);
		register(EntityFilteringFeature.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);
	
}
}
