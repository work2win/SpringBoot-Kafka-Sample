package com.work2win.config;

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
	
	 @Value("${spring.data.cassandra.keyspace-name}")
     private String keySpace;

     @Value("${spring.data.cassandra.contact-points}")
     private String contactPoints;

     @Value("${spring.data.cassandra.port}")
     private int port;

	@Override
	protected String getKeyspaceName() {
		// TODO Auto-generated method stub
		return keySpace;
	}
	
	@Override
    public String getContactPoints() {
        return contactPoints;
    }

    @Override
    public int getPort() {
        return port;
    }

}
