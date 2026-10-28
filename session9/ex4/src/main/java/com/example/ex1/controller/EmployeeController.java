package com.example.ex1.controller;

import com.example.ex1.model.dto.request.EmployeeCreateDTO;
import com.example.ex1.model.entity.Employee;
import com.example.ex1.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeCreateDTO employeeCreateDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeCreateDTO), HttpStatus.CREATED);
    }
}
