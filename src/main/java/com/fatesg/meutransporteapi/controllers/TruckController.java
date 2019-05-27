package com.fatesg.meutransporteapi.controllers;

import com.fatesg.meutransporteapi.entities.Truck;
import com.fatesg.meutransporteapi.interfaces.GenericOperationsController;
import com.fatesg.meutransporteapi.services.TruckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class TruckController implements GenericOperationsController<Truck> {

    @Autowired
    private TruckService service;

    Logger logger = LoggerFactory.getLogger(TruckController.class);

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)

    @Override
    public Resource<Truck> post(Truck entity) {
        try {
            service.save(entity);
            logger.info("Registro inserido");

            Link link = linkTo(TruckController.class).slash(entity.getIdTruck()).withSelfRel();
            return new Resource<>(entity, link);
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método POST.\nMensagem: %s", e.getMessage()));
            return null;
        }
    }

    @Override
    @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void put(Truck entity) {
        try {
            service.save(entity);
            logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e){
            logger.error(String.format("Erro ao executar o método PUT.\nMensagem: %s", e.getMessage()));
        }

    }

    @Override
    @DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Truck entity) {
        try {
            service.delete(entity);
            logger.info(String.format("Registro(s) deletado(s): %s",entity.toString()));
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método DELETE.\nMensagem: %s", e.getMessage()));
        }
    }

    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Resources<Truck> get() {
        try {
            List<Truck> entities = service.findAll();

            logger.info(String.format("Registro(s) recuperados(s): %s", entities.toString()));

            for (final Truck entity : entities) {
                Link selfLink = linkTo(DriverController.class)
                        .slash(entity.getIdTruck())
                        .withSelfRel();
                entity.add(selfLink);
            }
            Link link = linkTo(DriverController.class).withSelfRel();
            Resources<Truck> resources = new Resources<>(entities, link);
            return resources;
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s", e.getMessage()));
            return null;
        }
    }

    @Override
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Resource<Truck> get(Long id) {
        try {
            Truck entity = service.findById(id);
            logger.info(String.format("Registro recuperado: %s", entity.toString()));

            Link link = linkTo(DriverController.class).slash(entity.getIdTruck()).withSelfRel();
            return new Resource<>(entity, link);
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s", e.getMessage()));
            return null;
        }
    }

    @Override
    @PatchMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patch(Truck entity) {
        try {
            service.save(entity);
            logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método PATCH.\nMensagem: %s", e.getMessage()));
        }
    }
}
