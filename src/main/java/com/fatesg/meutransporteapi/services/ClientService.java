package com.fatesg.meutransporteapi.services;

import com.fatesg.meutransporteapi.entities.Client;
import com.fatesg.meutransporteapi.interfaces.GenericOperations;
import com.fatesg.meutransporteapi.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService implements GenericOperations<Client> {

    Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired private ClientRepository repository;


    @Override
    public List<Client> save(List<Client> entities) {
        try {
            logger.debug("\tMétodo save executado.");
            logger.debug("\tMétodo save invocado");
            List<Client> entitiesSaved = new ArrayList<>();
            for (Client entity: entities) {
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
    public Client save(Client entity){
        try {
            logger.debug("\tMétodo save executado.");
            logger.debug("\tMétodo save invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            entity.setInitialDate(new Date());
            Client entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
            return entitySaved;
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
            return null;
        }
    }

    @Override
    public List<Client> findAll() {
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
    public Client findById(Long id) {
        try {
            logger.debug("\tMétodo findById executado.");
            logger.debug("\tMétodo findById invocado");
            Optional<Client> optional = repository.findById(id);
            return optional.get();
        } catch (Exception e) {
            logger.error("Error ao recuperar registro." + e.getMessage());
            return null;
        }
    }

    @Override
    public void update(Client entity) {
        try {
            logger.debug("\tMétodo update executado.");
            logger.debug("\tMétodo update invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            Client entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
        }
    }

    @Override
    public void delete(Client entity) {
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
    public void patch(Client entity) {
        try {
            logger.debug("\tMétodo patch executado.");
            logger.debug("\tMétodo patch invocado");
            logger.debug(String.format("\tValor recebido: %s", entity.toString()));

            Client entitySaved = repository.save(entity);

            logger.info(String.format("\tValor persistido: %s", entitySaved.toString()));
        } catch (Exception e) {
            logger.error(String.format("Error ao persistir registro. \nMensagem:%s", e.getMessage()));
        }
    }

    @Override
    public void update(List<Client> entities) {
        try {
            logger.debug("\tMétodo update executado.");
            logger.debug("\tMétodo update invocado");
            for (Client entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.save(entity);
                logger.info(String.format("\tValor persistido: %s", entity.toString()));
            }
        } catch (Exception e) {
            logger.error("Error ao persistir registro.");
        }
    }

    @Override
    public void delete(List<Client> entities) {
        try {
            logger.debug("\tMétodo delete executado.");
            logger.debug("\tMétodo delete invocado");
            for (Client entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.delete(entity);
            }
        } catch (Exception e) {
            logger.error("Error ao deletar registro.");
        }
    }

    @Override
    public void patch(List<Client> entities) {
        try {
            logger.debug("\tMétodo patch executado.");
            logger.debug("\tMétodo patch invocado");
            for (Client entity: entities) {
                logger.debug(String.format("\tValor recebido: %s", entity.toString()));
                repository.delete(entity);
            }
        } catch (Exception e) {
            logger.error("Error ao persistir registro.");
        }
    }

}
