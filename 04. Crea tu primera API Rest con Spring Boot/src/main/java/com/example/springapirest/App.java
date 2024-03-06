package com.example.springapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springapirest.model.Manufacturer;
import com.example.springapirest.repository.ManufacturerRepository;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		var repo = context.getBean(ManufacturerRepository.class);
		repo.save(new Manufacturer(null, "manufacturer1", 1000, 1990));
	}

}
