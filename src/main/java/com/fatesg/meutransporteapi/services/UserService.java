package com.fatesg.meutransporteapi.services;

import com.fatesg.meutransporteapi.entities.User;
import com.fatesg.meutransporteapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.debug("\tMétodo loadUserByUsername invocado");
        Optional<User> result = repository.findByUserName(userName);

        if (!result.isPresent()) {
            logger.error("\tOcorreu um erro para o user: " + userName);
            throw new UsernameNotFoundException("Doesn't exist user with name: " + userName);
        }

        User user = result.get();
        logger.debug("\tValor recuperado: " + userName);

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));

        org.springframework.security.core.userdetails.User userSpring =
                            new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);

        return userSpring;
    }
}
