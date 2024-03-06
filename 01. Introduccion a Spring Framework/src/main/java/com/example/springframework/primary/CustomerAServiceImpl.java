package com.example.springframework.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
// Otra opcion es usar @Qualifier
@Primary
public class CustomerAServiceImpl implements CustomerService{
    @Override
    public String hello() {
        return "Hello from Customer A";
    }
}
