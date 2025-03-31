package com.example.springboot_lombok_api;

import com.example.springboot_lombok_api.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootLombokApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLombokApiApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner demo(ProductService productService) {
//		return (args) -> {
//			// Create some products using the ProductService interface
//			productService.createProduct("Laptop", 1000.00, 10);
//			productService.createProduct("Smartphone", 800.00, 50);
//
//			// Apply a discount to the first product
//			productService.applyDiscountToProduct(1L, 10.0);
//
//			// Print out all products
//			productService.getAllProducts().forEach(product -> {
//				System.out.println(product);
//			});
//		};
//	}
}
