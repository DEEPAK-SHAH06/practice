package com.bway.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Product;
import com.bway.springproject.repository.ProductRepository;
import com.bway.springproject.serviceImpl.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String getProductsByCategory(@RequestParam(value = "category", required = false) String category, Model model) {
	    List<Product> products;
	    if (category != null && !category.isEmpty()) {
	        products = productRepository.findByCategory(category);
	    } else {
	        products = productRepository.findAll();
	    }
	    model.addAttribute("products", products);
	    return "CategoryList"; // Name of the Thymeleaf template to display products
	}
	
	@GetMapping("/searchedProducts")
    public String getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search,
            Model model) {
        List<Product> products;

        // If search query is present
        if (search != null && !search.isEmpty()) {
            products = productService.findByTitleContaining(search);
        } else if (category != null && !category.isEmpty()) {
            products = productService.findByCategory(category);
        } else {
            products = productService.findAllProducts();
        }

        model.addAttribute("products", products);
        return "SearchedItem"; // Return the name of your HTML view
    }
}
