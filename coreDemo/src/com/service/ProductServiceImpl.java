package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService{
	
	//static List<Product> plist = new ArrayList<>();
	

	@Override
	public void adddProduct(Product prod) {
		
		//connect db :
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql = "insert into Product(name,price,company,category)values('"+prod.getName()+"',"+prod.getPrice()+" ,' "+prod.getCompany()+"', '"+prod.getProductCategory()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
//		plist.add(prod);
//		System.out.println("----added success-----Size = "+plist.size());
		
	}

	@Override
	public void deleteProduct(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql = "delete from Product where id = "+id+"";
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//plist.remove(index);		
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> prodList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql = "select * from Product";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
//				System.out.println("Id = "+rs.getInt("id"));
//				System.out.println("Company = "+rs.getString("company"));
//				System.out.println("Product Name = "+rs.getString("name"));
//				System.out.println("Price = "+rs.getInt("price"));
//				System.out.println("ProductCategory = "+rs.getString("category"));
//				System.out.println("---------------");
				
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setProductCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setCompany(rs.getString("company"));
				
				prodList.add(p);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//return plist;
		return prodList;
	}

	@Override
	public void updateProduct(Product prod) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql = "update Product  set name='"+prod.getName()+"',price = '"+prod.getPrice()+"',company = '"+prod.getCompany()+"',category = '"+prod.getProductCategory()+"' where id = "+prod.getId()+"";
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> searchProduct(String data) {
		List<Product> prodList = new ArrayList<>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deepak ","root","Shyam1122");
			String sql = "select * from Product where name like '%"+data+"%' OR company like '%"+data+"%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setProductCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setCompany(rs.getString("company"));
				
				prodList.add(p);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//return plist;
		return prodList;	}
	

}
