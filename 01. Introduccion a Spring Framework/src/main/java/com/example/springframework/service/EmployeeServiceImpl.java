package com.example.springframework.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class EmployeeServiceImpl implements EmployeeService{

    public String hello() {
        return "Hello from EmployeeServiceImpl";
    }
}
