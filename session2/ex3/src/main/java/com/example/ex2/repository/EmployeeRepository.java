package com.example.ex2.repository;

import com.example.ex2.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(1, "Employee 1", "employee1@gmail.com", "department 1"));
        employees.add(new Employee(2, "Employee 2", "employee2@gmail.com", "department 2"));
        employees.add(new Employee(3, "Employee 3", "employee3@gmail.com", "department 3"));
    }

    public List<Employee> findAll() {
        return employees;
    }
}
