package com.example.ex1.controller;

import com.example.ex1.model.dto.request.EmployeeCreateDTO;
import com.example.ex1.model.entity.Employee;
import com.example.ex1.service.EmployeeService;
import com.example.ex1.service.UploadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeCreateDTO employeeCreateDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeCreateDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/avatar")
    public ResponseEntity<Employee> uploadAvatar(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(uploadService.uploadAvatar(id, file), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
