package com.ra.ex3.service;

import com.ra.ex3.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = Arrays.asList(
            new Product(1, "product 1", 10000),
            new Product(2, "product 2", 20000),
            new Product(3, "product 3", 30000)
    );

    public List<Product> getAllProducts() {
        return products;
    }
}
