package com.example.springmvc;

import com.example.springmvc.entity.Product;
import com.example.springmvc.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		var repository = context.getBean(ProductRepository.class);

		List<Product> products = List.of(
				new Product("product1", 5.99, 1),
				new Product("product2", 6.99, 2),
				new Product("product3", 7.99, 4),
				new Product("product4", 8.99, 2),
				new Product("product5", 8.99, 2),
				new Product("product6", 8.99, 2)
		);
		repository.saveAll(products);
	}

}