package com.fatesg.meutransporteapi.repository;

import com.fatesg.meutransporteapi.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
