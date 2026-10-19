package com.example.ex1.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "total_price")
    private Double totalPrice;
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
