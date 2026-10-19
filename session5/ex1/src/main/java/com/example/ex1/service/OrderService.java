package com.example.ex1.service;

import com.example.ex1.model.entity.Order;
import com.example.ex1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrderByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrderByCustomerName(String name) {
        return orderRepository.findByCustomerNameContaining(name);
    }
}
