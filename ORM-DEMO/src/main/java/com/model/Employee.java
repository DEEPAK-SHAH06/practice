package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Table(name="employee")

public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private int salalry;
	@OneToOne
	@JoinColumn(name="adrId")//FK
	private Address address;
	
	@OneToMany(mappedBy = "employee")
    private List<Phone> phoneList;
	
	@ManyToMany
	@JoinTable(name="employee_department",joinColumns = {@JoinColumn(name="empId")},inverseJoinColumns= {@JoinColumn(name="deptId")})
	private List<Department> deptList;
	
	
	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSalalry() {
		return salalry;
	}
	public void setSalalry(int salalry) {
		this.salalry = salalry;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
