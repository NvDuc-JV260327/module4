package com.example.ex5.repository;

import com.example.ex5.model.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class EmployeeRepositoty {
    List<Employee> employees = new ArrayList<>();

    public EmployeeRepositoty() {
        employees.add(new Employee(1, "Employee1", "employee1@gmail.com", "department1"));
        employees.add(new Employee(2, "Employee2", "employee2@gmail.com", "department2"));
        employees.add(new Employee(3, "Employee3", "employee3@gmail.com", "department3"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee getById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findByName(String name) {
        List<Employee> listByName = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getFullName().toLowerCase().contains(name.toLowerCase())) {
                listByName.add(employee);
            }
        }
        return listByName;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee editEmployee(int id, Employee employee) {
        for(Employee employee1 : employees) {
            if(employee1.getId() == id) {
                employee1.setFullName(employee.getFullName());
                employee1.setEmail(employee.getEmail());
                employee1.setDepartment(employee.getDepartment());
                return employee;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}
