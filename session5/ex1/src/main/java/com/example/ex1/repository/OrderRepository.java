package com.example.ex1.repository;

import com.example.ex1.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findByStatus(String status);

    public List<Order> findByCustomerNameContaining(String name);
}
