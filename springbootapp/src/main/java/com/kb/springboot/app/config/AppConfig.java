package com.kb.springboot.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource({"classpath:/deployment.properties","classpath:/local.properties"})
@ComponentScan({"com.kb.springboot.app"})
public class AppConfig {

}
