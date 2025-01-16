package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

public interface CustomerSerivice {
	
	void addCustomer(Customer cust);
	void deleteCustomer(int index);
	List<Customer> getAllCustomer();

}
