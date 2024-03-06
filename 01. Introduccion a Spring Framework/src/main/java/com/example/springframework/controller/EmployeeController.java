package com.example.springframework.controller;

import com.example.springframework.primary.CustomerService;
import com.example.springframework.service.EmployeeService;
import com.example2.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    //@Autowired (Forma de inyeccion de dependencias, menos recomendada)
    private EmployeeService employeeService;

    //@Autowired
    // Otra opcion es usar @Qualifier("CustomerAServiceImpl) para especificar el bean que se quiere inyectar
    private CustomerService customerService;

    //@Autowired
    private HelloService helloService;

    // Opcion mas recomendada a la hora de inyectar dependencias
    public EmployeeController(EmployeeService employeeService, CustomerService customerService, HelloService helloService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.helloService = helloService;
    }

    public String helloEmployee() {
        return this.employeeService.hello();
    }

    public String helloCustomer() {
        return this.customerService.hello();
    }
}
