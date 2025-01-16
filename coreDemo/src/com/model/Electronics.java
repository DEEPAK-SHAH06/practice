package com.model;

public class Electronics {
	
	private String type;
	private String model;
	private String brand;
	private int price;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Electronics [type=" + type + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
	

}
