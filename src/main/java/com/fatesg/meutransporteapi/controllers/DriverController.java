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
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping("/drivers")
public class DriverController implements GenericOperationsController<Driver> {

    @Autowired private DriverService service;

    Logger logger = LoggerFactory.getLogger(DriverController.class);


    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public Resource<Driver> post(@RequestBody @Valid Driver entity) {
        try {
            service.save(entity);
            logger.info("Registro inserido");

            Link link = linkTo(DriverController.class).slash(entity.getIdUser()).withSelfRel();
            return new Resource<>(entity, link);
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método POST.\nMensagem: %s", e.getMessage()));
            return null;
        }
    }

    @Override
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void put(@RequestBody @Valid Driver entity) {
        try {
            service.save(entity);
            logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método PUT.\nMensagem: %s", e.getMessage()));
        }
    }

    @Override
    @DeleteMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable Long id) {
        try {
            service.delete(id);
            logger.info(String.format("Registro(s) deletado(s): %s", id.toString()));
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método DELETE.\nMensagem: %s", e.getMessage()));
        }
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaTypes.HAL_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Resources<Driver> get() {
        try {
            List<Driver> entities = service.findAll();

            logger.info(String.format("Registro(s) recuperados(s): %s", entities.toString()));

            for (final Driver entity : entities) {
                Link selfLink = linkTo(DriverController.class)
                        .slash(entity.getIdUser())
                        .withSelfRel();
                entity.add(selfLink);
            }
            Link link = linkTo(DriverController.class).withSelfRel();
            Resources<Driver> resources = new Resources<>(entities, link);
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
    @CrossOrigin
    public Resource<Driver> get(@PathVariable Long id) {
        try {
            Driver entity = service.findById(id);
            logger.info(String.format("Registro recuperado: %s", entity.toString()));

            Link link = linkTo(DriverController.class).slash(entity.getIdUser()).withSelfRel();
            return new Resource<>(entity, link);
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s", e.getMessage()));
            return null;
        }
    }

    @Override
    @PatchMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void patch(@RequestBody Driver entity) {
        try {
            service.save(entity);
            logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e) {
            logger.error(String.format("Erro ao executar o método PATCH.\nMensagem: %s", e.getMessage()));
        }
    }

}
