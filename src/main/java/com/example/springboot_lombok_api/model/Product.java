package com.example.springboot_lombok_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private double price;
    private int stockQuantity;

    // Business logic method to apply discount
    public void applyDiscount(double percentage)
    {
        //log.info("Applying {}% discount to product: {}", percentage, name);
        this.price = this.price - (this.price * percentage / 100);
    }


}
