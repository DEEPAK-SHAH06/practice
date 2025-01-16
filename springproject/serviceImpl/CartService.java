package com.bway.springproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Cart;
import com.bway.springproject.model.Product;
import com.bway.springproject.repository.CartRepository;
import com.bway.springproject.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(Cart cart) {
            cartRepository.save(cart);
    }
    
    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }
    
}

