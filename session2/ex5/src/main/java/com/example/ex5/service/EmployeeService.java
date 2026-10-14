package com.example.ex5.service;

import com.example.ex5.model.entity.Employee;
import com.example.ex5.repository.EmployeeRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepositoty employeeRepositoty;

    public List<Employee> getAllEmployee() {
        return employeeRepositoty.findAll();
    }

    public Employee findById(int id) {
        return employeeRepositoty.getById(id);
    }

    public List<Employee> getByName(String name) {
        return employeeRepositoty.findByName(name);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepositoty.addEmployee(employee);
    }

    public Employee editEmployee(int id, Employee employee) {
        return employeeRepositoty.editEmployee(id, employee);
    }

    public boolean deleteEmployee(int id) {
        return employeeRepositoty.deleteEmployee(id);
    }
}
