package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class TestProduct {
	public static void main(String[] args) {
		add();
		//getAll();
		delete();
		//show data after delete method.
		getAll();
	}
	//add product
	static void add() {
		ProductService ps = new ProductServiceImpl();
		char flag ='y';
		Scanner sc = new Scanner(System.in);
		do {
			Product p  = new Product();
			System.out.println("Enter ID : ");
			p.setId(sc.nextInt());
			System.out.println("Enter Company Name : ");
			p.setCompany(sc.next());
			System.out.println("Enter Product Name : ");
			p.setName(sc.next());
			System.out.println("Enter the price of Product : ");
			p.setPrice(sc.nextInt());
			System.out.println("Enter the category of Product : ");
			p.setProductCategory(sc.next());
			
			ps.adddProduct(p);
			System.out.println("Do you want to add more [y/n];");
			flag =sc.next().charAt(0);
		}while(flag=='y');
		
	}
	//get allProduct
	static void getAll() {
		ProductService ps = new ProductServiceImpl();
		List<Product> plist = ps.getAllProducts();	
		System.out.println(plist);
		
	}
	
	static void delete() {
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct(17);//index=0;
		 
	}

	
	
	
	
	
	
	
}
