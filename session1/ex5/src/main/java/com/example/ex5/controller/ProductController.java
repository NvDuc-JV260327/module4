package com.example.ex5.controller;

import com.example.ex5.model.entity.Product;
import com.example.ex5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.editProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if(productService.deleteProduct(id)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }
}
