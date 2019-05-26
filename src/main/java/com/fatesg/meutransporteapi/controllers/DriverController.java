package com.fatesg.meutransporteapi.controllers;


import com.fatesg.meutransporteapi.entities.Driver;
import com.fatesg.meutransporteapi.interfaces.GenericOperationsController;
import com.fatesg.meutransporteapi.services.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;

@RestController
@RequestMapping("/motoristas")
public class DriverController implements GenericOperationsController<Driver> {

    @Autowired private DriverService service;

    Logger logger = LoggerFactory.getLogger(DriverController.class);


    @Override
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Resource<Driver> post(@RequestBody @Valid Driver entity) {
        try {
            service.save(entity);
            logger.info("Registro inserido");

            Link link = linkTo(DriverController.class).slash(entity.getIdPeople()).withSelfRel();
            return new Resource<>(entity, link);
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método POST.\nMensagem: %s", e.getMessage()));
        }
        return null;
    }

    @Override
    public void put(Driver entity) {

    }

    @Override
    public void delete(Driver entity) {

    }

    @Override
    public Resources<Driver> get() {
        return null;
    }

    @Override
    public Resource<Driver> get(Long id) {
        return null;
    }

    @Override
    public void patch(Driver entity) {

    }

    @PostMapping
    public ResponseEntity<Driver> save(@RequestBody Driver driver){
        Driver driverSaved = service.save(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverSaved);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> findAll() {
        List<Driver> drivers = service.findAll();
        return ResponseEntity.ok(drivers);
    }

}
