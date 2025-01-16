package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.model.Product;

public class CustomerServiceImpl implements CustomerSerivice{

	static List<Customer> clist = new ArrayList<>();
	
	@Override
	public void addCustomer(Customer cust) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql="insert into Customer(name,address,phone_no,age,gmail)values('"+cust.getName()+"','"+cust.getAddress()+"','"+cust.getPhoneNo()+"',"+cust.getAge()+",'"+cust.getGmail()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteCustomer(int index) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql=("delete from Customer where id = "+index+" ");
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak", "root", "Shyam1122");
			String sql = ("Select * from Customer");
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				System.out.println("Name : "+result.getInt("name"));
				System.out.println("Address : "+result.getString("address"));
				System.out.println("PHONE NO. : "+result.getString("phone_no."));
				System.out.println("Age : "+result.getInt("age"));
				System.out.println("Gmail : "+result.getString("gmail"));
				System.out.println("--------------------");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clist;
	}

}
