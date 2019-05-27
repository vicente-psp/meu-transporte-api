package com.fatesg.meutransporteapi.controllers;

import com.fatesg.meutransporteapi.entities.Truck;
import com.fatesg.meutransporteapi.interfaces.GenericOperationsController;
import com.fatesg.meutransporteapi.services.TruckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public class TruckController implements GenericOperationsController<Truck> {

    @Autowired
    private TruckService service;

    Logger logger = LoggerFactory.getLogger(TruckController.class);

    @Override
    public Resource<Truck> post(Truck entity) {
        return null;
    }

    @Override
    public void put(Truck entity) {

    }

    @Override
    public void delete(Truck entity) {

    }

    @Override
    public Resources<Truck> get() {
        return null;
    }

    @Override
    public Resource<Truck> get(Long id) {
        return null;
    }

    @Override
    public void patch(Truck entity) {

    }
}
