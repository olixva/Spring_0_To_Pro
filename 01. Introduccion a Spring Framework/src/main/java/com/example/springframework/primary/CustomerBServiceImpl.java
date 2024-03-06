package com.example.springframework.primary;

import org.springframework.stereotype.Service;

@Service
public class CustomerBServiceImpl implements CustomerService {
    @Override
    public String hello() {
        return "Hello from Customer B";
    }
}
