package com.example.ex1.service;

import com.example.ex1.Exception.DuplicateResourceException;
import com.example.ex1.Exception.ResourceNotFoundException;
import com.example.ex1.model.dto.request.EmployeeCreateDTO;
import com.example.ex1.model.entity.Department;
import com.example.ex1.model.entity.Employee;
import com.example.ex1.repository.DepartmentRepository;
import com.example.ex1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Department department = departmentRepository.findById(employeeCreateDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Id phòng ban không tồn tại"));
        if(employeeRepository.existsByEmail(employeeCreateDTO.getEmail())) {
            throw new DuplicateResourceException("Email đã tồn tại");
        }
        Employee employee = Employee.builder()
                .fullName(employeeCreateDTO.getFullName())
                .email(employeeCreateDTO.getEmail())
                .phone(employeeCreateDTO.getPhone())
                .salary(employeeCreateDTO.getSalary())
                .department(department)
                .build();
        return employeeRepository.save(employee);
    }
}
