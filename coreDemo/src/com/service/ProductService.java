package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	
	void adddProduct(Product prod);
	
	void deleteProduct(int id);
	
	List<Product> getAllProducts();
	
	void updateProduct(Product prod);
	List<Product> searchProduct(String data);

}
