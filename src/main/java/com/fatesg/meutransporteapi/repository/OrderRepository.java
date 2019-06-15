package com.fatesg.meutransporteapi.repository;

import com.fatesg.meutransporteapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
