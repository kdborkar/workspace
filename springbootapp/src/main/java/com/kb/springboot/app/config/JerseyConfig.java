package com.kb.springboot.app.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig{
	public JerseyConfig(){
		register(RequestContextFilter.class);
		packages("com.kb.springboot.app.rest");
		register(LoggingFilter.class);
	}

}
