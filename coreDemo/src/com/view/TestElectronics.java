package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Electronics;
import com.service.ElectronicsService;
import com.service.ElectronicsImpl;

public class TestElectronics {
	public static void main(String[] args) {
		addItem();
		getAllItem();
		
	}
	
	 static void addItem() {

		ElectronicsService elecserv = new ElectronicsImpl();
		char flag = 'y';
		Electronics el = new Electronics();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter the Type of Electronics");
			el.setType(sc.next());
			System.out.println("Enter the Brand of product : ");
			el.setBrand(sc.next());
			System.out.println("Enter the Model of Product : ");
			el.setModel(sc.next());
			System.out.println("Enter the Price : ");
			el.setPrice(sc.nextInt());
			
			System.out.println("Do you want to continue [y/n]");
			flag = sc.next().charAt(0);
			elecserv.addElectronics(el);
		}while(flag=='y');
		
		
	}
	 
	 static void removeItem() {

		 ElectronicsService elecserv = new ElectronicsImpl();
		 elecserv.removeElectronics(0);
	 }
	 
	 static void getAllItem() {
		 ElectronicsService elecserv = new ElectronicsImpl();
		 List<Electronics> elist = elecserv.getAllElectronics();
		 System.out.println(elist);
		 
	 }
	 

}
