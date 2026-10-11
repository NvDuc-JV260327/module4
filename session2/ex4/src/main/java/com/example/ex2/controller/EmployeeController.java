package com.example.ex2.controller;

import com.example.ex2.model.dto.EmployeeFilter;
import com.example.ex2.model.entity.Employee;
import com.example.ex2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmloyee(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getEmployeeByName(name));
    }

    @GetMapping("/filter")
    public ResponseEntity<String> filterEmployee(@ModelAttribute EmployeeFilter filter) {
        return ResponseEntity.ok("Đang lọc theo tên: " + filter.getName() + " và phòng ban: " + filter.getDepartment());
    }
}
