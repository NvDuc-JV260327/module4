package com.example.ex5.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
