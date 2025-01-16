package com.bway.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springproject.model.Cart;
import com.bway.springproject.model.Product;
import com.bway.springproject.serviceImpl.CartService;
import com.bway.springproject.serviceImpl.ProductService;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private ProductService prodService;

    @GetMapping("/product/addCart")
    public ResponseEntity<String> addToCart(@RequestParam Integer id) {
    	
    	Product p = prodService.getById(id);
    	Cart  ct = new Cart();
    	ct.setProductId(id);
    	ct.setPrice(p.getPrice());
    	ct.setProductName(p.getTitle());
    	
    	cartService.addToCart(ct);
    	
        //cartService.addToCart(userId, productId);
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @GetMapping("/list")
    public List<Cart> getCartItems(@RequestParam Long userId) {
        return cartService.getCartItems(userId);
    }
}
