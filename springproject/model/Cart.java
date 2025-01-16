package com.bway.springproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer productId; // Foreign key reference to Product
    private Long userId; // Foreign key reference to User

    private Integer quantity;

    private String productName; // Store the product name
    private Double price; // Store the product price
}
