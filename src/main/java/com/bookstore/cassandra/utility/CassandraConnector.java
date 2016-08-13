package com.bookstore.cassandra.utility;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.bookstore.cassandra.repository.BookstoreRepository;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Configuration
@PropertySource(value={"classpath:database.properties"})
public abstract class CassandraConnector implements BookstoreRepository{

	@Inject
	private Environment env;
	
	private String host;
	private String keyspace;
	private Cluster cluster;
	protected Session session;
	private Logger logger = LoggerFactory.getLogger(CassandraConnector.class);
	
	public void init(){
		host = env.getProperty("cassandraHost");
		keyspace = env.getProperty("keyspace");
		cluster= Cluster.builder().addContactPoint(host).build();
		session = cluster.connect(keyspace);
	}
	
	public  Session connect(){
		//logger.info(env.getProperty("cassandraHost").toUpperCase());
		
			cluster = Cluster.builder().addContactPoint(host).build();
			session = cluster.connect();
		
		return session;
	}
	
	public void destroy(){
		session.close();
		cluster.close();
	}
	
	public Session getSession(){
		return session==null?connect():session;
	}
}