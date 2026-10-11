package com.example.ex2.service;

import com.example.ex2.model.entity.Employee;
import com.example.ex2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id).orElse(null);
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findAll().stream().filter(e -> e.getFullName().toLowerCase()
                .contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
