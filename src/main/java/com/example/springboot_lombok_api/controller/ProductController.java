package com.example.springboot_lombok_api.controller;

import com.example.springboot_lombok_api.model.Product;
import com.example.springboot_lombok_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    ProductService productService;

    // Create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.createProduct(product.getName(), product.getPrice(), product.getStockQuantity());
        return ResponseEntity.ok(savedProduct);
    }

    // Get all products
    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id)
    {
        Optional<Product> product = productService.getProductId(id);
        return product.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    // Apply discount to a product
    @PatchMapping("/{id}/discount")
    public ResponseEntity<Product> applyDiscount(@PathVariable Long id, @RequestParam double percentage)
    {
        Product updatedProduct = productService.applyDiscountToProduct(id, percentage);
        return ResponseEntity.ok(updatedProduct);
    }



}
