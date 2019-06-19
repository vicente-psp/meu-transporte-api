package com.fatesg.meutransporteapi.services;

import com.fatesg.meutransporteapi.entities.Driver;
import com.fatesg.meutransporteapi.interfaces.GenericOperations;
import com.fatesg.meutransporteapi.repository.DriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DriverService implements GenericOperations<Driver> {

    Logger logger = LoggerFactory.getLogger(DriverService.class);

    @Autowired private DriverRepository repository;

    @Override
    public List<Driver> save(List<Driver> entities) {
        try {
            logger.debug("\tMétodo save executado.");
            logger.debug("\tMétodo save invocado");
            List<Driver> entitiesSaved = new ArrayList<>();
            for (Driver entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                entity.setInitialDate(new Date());
                repository.save(entity);
                logger.info(String.format("\tValor persistido: %s", entity.toString()));
                entities.add(entity);
            }
            return entitiesSaved;
        } catch (Exception e) {
            logger.error("Error ao persistir registro.");
            return null;
        }
    }

    @Override
    public Driver save(Driver entity){
        try {
            logger.debug("\tMétodo save executado.");
            logger.debug("\tMétodo save invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            entity.setInitialDate(new Date());
            Driver entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
            return entitySaved;
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
            return null;
        }
    }

    @Override
    public List<Driver> findAll() {
        try {
            logger.debug("\tMétodo findAll executado.");
            logger.debug("\tMétodo findAll invocado");
            return repository.findAll();
        } catch (Exception e) {
            logger.error("Error ao recuperar registro." + e.getMessage());
            return null;
        }
    }

    @Override
    public Driver findById(Long id) {
        try {
            logger.debug("\tMétodo findById executado.");
            logger.debug("\tMétodo findById invocado");
            Optional<Driver> optional = repository.findById(id);
            return optional.get();
        } catch (Exception e) {
            logger.error("Error ao recuperar registro." + e.getMessage());
            return null;
        }
    }

    @Override
    public void update(Driver entity) {
        try {
            logger.debug("\tMétodo update executado.");
            logger.debug("\tMétodo update invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            Driver entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
        }
    }

    @Override
    public void delete(Driver entity) {
        try {
            logger.debug("\tMétodo delete executado.");
            logger.debug("\tMétodo delete invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            repository.delete(entity);
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
        }
    }

    @Override
    public void patch(Driver entity) {
        try {
            logger.debug("\tMétodo patch executado.");
            logger.debug("\tMétodo patch invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            Driver entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
        }
    }

    @Override
    public void update(List<Driver> entities) {
        try {
            logger.debug("\tMétodo update executado.");
            logger.debug("\tMétodo update invocado");
            for (Driver entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.save(entity);
                logger.info(String.format("\tValor persistido: %s", entity.toString()));
            }
        } catch (Exception e) {
            logger.error("Error ao persistir registro.");
        }
    }

    @Override
    public void delete(List<Driver> entities) {
        try {
            logger.debug("\tMétodo delete executado.");
            logger.debug("\tMétodo delete invocado");
            for (Driver entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.delete(entity);
            }
        } catch (Exception e) {
            logger.error("Error ao deletar registro.");
        }
    }

    @Override
    public void patch(List<Driver> entities) {
        try {
            logger.debug("\tMétodo patch executado.");
            logger.debug("\tMétodo patch invocado");
            for (Driver entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.delete(entity);
            }
        } catch (Exception e) {
            logger.error("Error ao persistir registro.");
        }
    }

}
