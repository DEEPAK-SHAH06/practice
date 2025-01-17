package com.bway.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bway.springproject.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	    
	    List<Product> findByCategory(String category);
	    List<Product> findByTitleContainingIgnoreCase(String title);
	
}
