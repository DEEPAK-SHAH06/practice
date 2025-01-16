package com.model;

public class Product {
	
	private int id;
	private int price;
	private String company;
	private String name;
	private String productCategory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", Company=" + company + ", name=" + name
				+ ", ProductCategory=" + productCategory + "]";
	}
	
	

}
