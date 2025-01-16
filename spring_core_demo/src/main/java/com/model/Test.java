package com.model;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Product p =(Product) context.getBean("prod");
		p.printProduct();
		
		Category c = (Category)context.getBean("getCategoryBean");
		c.printCategory();
	}
}
