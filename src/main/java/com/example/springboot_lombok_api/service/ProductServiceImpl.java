package com.example.springboot_lombok_api.service;


import com.example.springboot_lombok_api.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    // In-memory list to store products
    private List<Product> products = new ArrayList<>();

    // Create a new product
    @Override
    public Product createProduct(String name, double price, int stockQuantity) {
        Product product = Product.builder()
                .id((long) (products.size() + 1))
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
        return product;
    }

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    // Get a product by ID
    @Override
    public Optional<Product> getProductId(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public Product applyDiscountToProduct(Long id, double percentage) {
        Product product = getProductId(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        product.applyDiscount(percentage);
        return product;
    }
}
