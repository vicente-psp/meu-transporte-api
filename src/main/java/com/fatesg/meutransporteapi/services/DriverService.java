package com.fatesg.meutransporteapi.services;

import com.fatesg.meutransporteapi.entities.Driver;
import com.fatesg.meutransporteapi.interfaces.GenericOperations;
import com.fatesg.meutransporteapi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements GenericOperations<Driver> {

    @Autowired private DriverRepository repository;


    @Override
    public List<Driver> save(List<Driver> entities) {
        return null;
    }

    @Override
    public Driver save(Driver driver){
        return repository.save(driver);
    }

    @Override
    public List<Driver> findAll() {
        return repository.findAll();
    }

    @Override
    public Driver findById(Long id) {
        return null;
    }

    @Override
    public void update(Driver entity) {

    }

    @Override
    public void delete(Driver entity) {

    }

    @Override
    public void patch(Driver entity) {

    }

    @Override
    public void update(List<Driver> entities) {

    }

    @Override
    public void delete(List<Driver> entities) {

    }

    @Override
    public void patch(List<Driver> entities) {

    }

}
