package com.model;

public class Customer {
	private String name;
	private String Address;
	private String PhoneNo;
	private int age;
	private String gmail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", Address=" + Address + ", PhoneNo=" + PhoneNo + ", age=" + age + ", gmail="
				+ gmail + "]";
	}
	

}
