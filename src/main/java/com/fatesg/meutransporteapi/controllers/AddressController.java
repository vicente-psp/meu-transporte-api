package com.fatesg.meutransporteapi.controllers;

import com.fatesg.meutransporteapi.entities.Address;
import com.fatesg.meutransporteapi.interfaces.GenericOperationsController;
import com.fatesg.meutransporteapi.services.AddressClient;
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
@RequestMapping("/clients")
public class AddressController implements GenericOperationsController<Address> {

@Autowired
private AddressClient service;

        Logger logger = LoggerFactory.getLogger(AddressController.class);


@Override
@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
        produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
                MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.CREATED)
public Resource<Address> post(@RequestBody @Valid Address entity) {
        try {
        service.save(entity);
        logger.info("Registro inserido");

        Link link = linkTo(AddressController.class).slash(entity.getIdAddress()).withSelfRel();
        return new Resource<>(entity, link);
        } catch (Exception e) {
        logger.error(String.format("Erro ao executar o método POST.\nMensagem: %s", e.getMessage()));
        return null;
        }
        }

@Override
@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
public void put(Address entity) {
        try {
        service.save(entity);
        logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e) {
        logger.error(String.format("Erro ao executar o método PUT.\nMensagem: %s", e.getMessage()));
        }
        }

@Override
@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(Address entity) {
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
public Resources<Address> get() {
        try {
        List<Address> entities = service.findAll();

        logger.info(String.format("Registro(s) recuperados(s): %s", entities.toString()));

        for (final Address entity : entities) {
            Link selfLink = linkTo(AddressController.class)
                    .slash(entity.getIdAddress())
                    .withSelfRel();
            entity.add(selfLink);
        }
        Link link = linkTo(AddressController.class).withSelfRel();
        Resources<Address> resources = new Resources<>(entities, link);
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
public Resource<Address> get(@PathVariable Long id) {
        try {
        Address entity = service.findById(id);
        logger.info(String.format("Registro recuperado: %s", entity.toString()));

        Link link = linkTo(AddressController.class).slash(entity.getIdAddress()).withSelfRel();
        return new Resource<>(entity, link);
        } catch (Exception e) {
        logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s", e.getMessage()));
        return null;
        }
        }

@Override
@PatchMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
public void patch(Address entity) {
        try {
        service.save(entity);
        logger.info(String.format("Registro atualizado: %s", entity.toString()));
        } catch (Exception e) {
        logger.error(String.format("Erro ao executar o método PATCH.\nMensagem: %s", e.getMessage()));
        }
        }
}
