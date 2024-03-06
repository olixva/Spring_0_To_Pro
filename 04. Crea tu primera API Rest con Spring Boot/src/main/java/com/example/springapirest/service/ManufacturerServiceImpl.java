package com.example.springapirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springapirest.model.Manufacturer;
import com.example.springapirest.repository.ManufacturerRepository;
import java.util.Objects;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByYear(Integer year) {
        Objects.requireNonNull(year);
        return manufacturerRepository.findAllByYear(year);
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> findByName(String name) {
        return null;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
    }

}
