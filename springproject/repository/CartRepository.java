package com.bway.springproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bway.springproject.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	 List<Cart> findByUserId(Long userId);
	 Optional<Cart> findByUserIdAndProductId(Long userId, Integer productId);
	
}
