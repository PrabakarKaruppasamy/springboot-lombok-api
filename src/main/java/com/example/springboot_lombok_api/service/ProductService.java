package com.example.springboot_lombok_api.service;

import com.example.springboot_lombok_api.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Create a new product
    Product createProduct(String name, double price, int stockQuantity);

    // Get all products
    List<Product> getAllProducts();

    // Get a product by ID
    Optional<Product> getProductId(Long id);

    // Apply discount to a product
    Product applyDiscountToProduct(Long id, double percentage);
}
