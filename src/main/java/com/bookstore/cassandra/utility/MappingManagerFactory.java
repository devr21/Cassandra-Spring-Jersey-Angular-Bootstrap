package com.bookstore.cassandra.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;

public class MappingManagerFactory {
	
	private MappingManager manager;
	private Logger logger = LoggerFactory.getLogger(MappingManagerFactory.class);
	
	private CassandraConnector cassConnector;
	
	public void setMappingManager(MappingManager manager){
		this.manager = manager;
	}
	
	public void setCassandraConnector(CassandraConnector connector){
		this.cassConnector = connector;
	}
	
	public void disconnect(){
		//cassConnector.disconnect();
	}
	
	public MappingManager getManager(){
		if(manager == null)
			logger.info("Manager is NUll");
		return manager == null?new MappingManager(cassConnector.connect()):manager;
	}
	
	public Session getSession(){
		return cassConnector.getSession();
	}
	
}
