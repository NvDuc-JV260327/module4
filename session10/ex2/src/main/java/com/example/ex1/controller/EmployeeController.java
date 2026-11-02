package com.example.ex1.controller;

import com.example.ex1.model.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Employee 1", 1000d));
        employees.add(new Employee(2L, "Employee 2", 2000d));
        employees.add(new Employee(3L, "Employee 3", 3000d));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/auth/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Đăng nhập thành công!", HttpStatus.OK);
    }
}
