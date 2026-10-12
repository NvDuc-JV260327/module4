package com.example.ex5.service;

import com.example.ex5.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.addAll(List.of(
                new Product(1, "Product1", 10000),
                new Product(2, "Product2", 20000),
                new Product(3, "Product3", 30000)
                )
        );
    }

    public List<Product> getAllProduct() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product editProduct(int id, Product product) {
        products.set(id, product);
        return product;
    }

    public boolean deleteProduct(int deleteId) {
        return products.removeIf(p -> p.getId() == deleteId);
    }
}
