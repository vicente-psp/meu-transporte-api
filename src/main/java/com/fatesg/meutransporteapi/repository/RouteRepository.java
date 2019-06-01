package com.fatesg.meutransporteapi.repository;

import com.fatesg.meutransporteapi.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Long> {
}
