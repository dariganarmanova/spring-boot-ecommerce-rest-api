package com.example.project.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
    Optional<Order> findByUserId(Long id);
    List<Order> findAll();
}
