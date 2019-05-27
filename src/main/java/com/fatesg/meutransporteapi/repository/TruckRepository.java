package com.fatesg.meutransporteapi.repository;

import com.fatesg.meutransporteapi.entities.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

}
