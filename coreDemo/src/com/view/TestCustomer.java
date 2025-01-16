package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Product;
import com.service.CustomerSerivice;
import com.service.CustomerServiceImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class TestCustomer {
	
	public static void main(String[] args) {
		addPeople();
		getAllpeople();
//		removePeople();
//		getAllpeople();
	}
	
	static void addPeople() {
		CustomerSerivice  cs= new CustomerServiceImpl();
		char flag ='y';
		Scanner sc = new Scanner(System.in);
		do {
			Customer cu  = new Customer();
			System.out.println("Enter Name : ");
			cu.setName(sc.next());
			System.out.println("Enter Address : ");
			cu.setAddress(sc.next());
			System.out.println("Enter Phone no. : ");
			cu.setPhoneNo(sc.next());
			System.out.println("Enter Age : ");
			cu.setAge(sc.nextInt());
			System.out.println("Enter you gmail. : ");
			cu.setGmail(sc.next());
			
			cs.addCustomer(cu);
			
			System.out.println("Do you want to add more [y/n];");
			flag =sc.next().charAt(0);
		}while(flag=='y');
		
	}
	static void removePeople() {
		
		CustomerSerivice  cs= new CustomerServiceImpl();
		cs.deleteCustomer(6);
	}
	static void getAllpeople() {
		CustomerSerivice  cs= new CustomerServiceImpl();
		List<Customer> clist = cs.getAllCustomer();	
		System.out.println(clist);
		
	}

	
}
