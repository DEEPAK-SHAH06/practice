package com.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 			//used to start spring container
@ComponentScan(basePackages="com.model")
public class AppConfig {
	
	@Bean 
	public Category getCategoryBean() {
		return new Category();
	}

}
