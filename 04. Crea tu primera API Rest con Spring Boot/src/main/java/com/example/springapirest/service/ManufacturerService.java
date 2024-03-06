package com.example.springapirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springapirest.model.Manufacturer;

public interface ManufacturerService {

    // RETRIEVE
    List<Manufacturer> findAll();
    List<Manufacturer> findAllByYear(Integer year);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> findByName(String name);
    
    // CREATE AND UPDATE
    Manufacturer save(Manufacturer manufacturer);

    // DELETE
    void deleteById(Long id);

    void deleteAll();
    
    //Other enterprise methods
        // Coches fabricados por un fabricante
        // Beneficios de un fabricante
        // ect...
    
}