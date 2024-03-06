package com.example.springframework;

import com.example.springframework.controller.EmployeeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Por defecto, @ComponentScan escanea el paquete donde esta el Main.
@ComponentScan({"com.example", "com.example2"})
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);

		EmployeeController employeeController = context.getBean(EmployeeController.class);
		System.out.println(employeeController.helloEmployee());
		System.out.println(employeeController.helloCustomer());
	}

}
