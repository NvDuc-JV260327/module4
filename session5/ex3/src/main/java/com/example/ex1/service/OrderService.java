package com.example.ex1.service;

import com.example.ex1.model.entity.Order;
import com.example.ex1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    // lấy danh sách order theo status
    public List<Order> getOrderByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    // lấy danh sách order theo tên khách hàng
    public List<Order> getOrderByCustomerName(String name) {
        return orderRepository.findByCustomerNameContaining(name);
    }

    // lấy danh sách sắp xếp
    public List<Order> getAllOrdersSorted(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(field).ascending() : Sort.by(field).descending();
        return orderRepository.findAll(sort);
    }

    // lấy danh sách có phân trang và sắp xếp
    public Page<Order> getOrdersPaged(int page, int size) {
        Sort sort = Sort.by("createdAt").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return orderRepository.findAll(pageable);
    }
}
