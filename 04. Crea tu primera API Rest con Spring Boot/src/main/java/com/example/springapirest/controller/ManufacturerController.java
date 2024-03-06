package com.example.springapirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapirest.model.Manufacturer;
import com.example.springapirest.service.ManufacturerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    /*
     * GET http://localhost:8080/api/manufacturers
     */
    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> findAll() {
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        if (manufacturers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(manufacturers);
    }

    /*
     * GET http://localhost:8080/api/manufactures/year/{year} :
     */
    @GetMapping("/manufacturers/year/{year}")
    public ResponseEntity<List<Manufacturer>> findByYear(@PathVariable Integer year) {
        List list = manufacturerService.findAllByYear(year);

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }

    /*
     * GET http://localhost:8080/api/manufactures/{id} :
     */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id) {
        return manufacturerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> create(@RequestBody Manufacturer manufacturer) {
        //Comprobaciones
        if (manufacturer.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        this.manufacturerService.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @PutMapping("/manufacturers")
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer) {
        this.manufacturerService.save(manufacturer);
        return ResponseEntity.ok(manufacturer);
    }

    @DeleteMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable("id") Long id) {
        this.manufacturerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
