package com.example.ex1.service;

import com.example.ex1.model.dto.request.DepartmentDTO;
import com.example.ex1.model.entity.Department;
import com.example.ex1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department newDepartment = Department.builder()
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();
        return departmentRepository.save(newDepartment);
    }
}
