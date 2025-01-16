package com.view;

import java.util.List;
import java.util.Scanner;


import com.model.Marketing;
import com.model.Product;
import com.service.MarketingService;
import com.service.MarketingServiceImpl;

public class TestMarketing {
	public static void main(String[] args) {
		addGroup();
		getAllGroup();
		removeGroup();
		getAllGroup();
		
	}
	
   static void addGroup() {
	   MarketingService ms = new MarketingServiceImpl();
	   char flag = 'y';
	   Scanner Sc = new Scanner(System.in);
	   do {
			Marketing m = new Marketing();
			System.out.println("Enter Team ID : ");
			m.setTeamID(Sc.nextInt());
			System.out.println("Enter Team Name : ");
			m.setName(Sc.next());
			System.out.println("Enter Team Category of Marketing : ");
			m.setCategory(Sc.next());
			System.out.println("Enter the area of Marketing");
			m.setArea(Sc.next());
			
			ms.addTeam(m);  
			
			System.out.println("Do you want to continue {y/n}");
			flag =Sc.next().charAt(0);	
			
		}while(flag=='y');
		  	
    	 	
    	
    }
   
   static void removeGroup() {
	   MarketingService ms = new MarketingServiceImpl();
	   ms.deleteTeam(0);
   }
   
   static void getAllGroup() {
	   MarketingService ms = new MarketingServiceImpl();
	   List<Marketing> mlist = ms.getAllTeam();	
	   System.out.println(mlist);
	   
   }

}
