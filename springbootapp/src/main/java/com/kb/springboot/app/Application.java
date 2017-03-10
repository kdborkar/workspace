package com.kb.springboot.app;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.kb.springboot.app.config.AppConfig;

@EnableAutoConfiguration
@ComponentScan("com.kb.springboot.app")
public class Application {

	public static void main(String[] args) {
		//ApplicationContext ctx = new SpringApplicationBuilder(Application.class).run(args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Hello World!");

	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletContainer(),"/retail-manager/*");
		registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyAutoConfiguration.class.getName());
		return registrationBean;
	}
}
