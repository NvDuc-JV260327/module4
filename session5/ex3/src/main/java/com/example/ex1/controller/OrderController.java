package com.example.ex1.controller;

import com.example.ex1.model.entity.Order;
import com.example.ex1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/search-status")
    public ResponseEntity<List<Order>> getOrderByStatus(@RequestParam String status) {
        return new ResponseEntity<>(orderService.getOrderByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/search-by-customer")
    public ResponseEntity<List<Order>> getOrderByCustomerName(@RequestParam String customerName) {
        return new ResponseEntity<>(orderService.getOrderByCustomerName(customerName), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Order>> getAllOrdersSorted(@RequestParam("sortBy") String sortBy, @RequestParam("dir") String dir) {
        return new ResponseEntity<>(orderService.getAllOrdersSorted(sortBy, dir), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<Order>> getOrdersPaged(@RequestParam("page") int page, @RequestParam("size") int size) {
        return new ResponseEntity<>(orderService.getOrdersPaged(page, size), HttpStatus.OK);
    }
}
