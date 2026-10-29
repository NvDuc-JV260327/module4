package com.example.ex1.service;

import com.example.ex1.Exception.ResourceNotFoundException;
import com.example.ex1.model.entity.Employee;
import com.example.ex1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee uploadAvatar(Long id, MultipartFile file) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id không tồn tại")
        );

        if(file.isEmpty()) {
            throw new RuntimeException("File trống");
        }

        if(file.getSize() > 2*1024*1024) {
            throw new RuntimeException();
        }

        String contentType = file.getContentType();
        if(contentType == null || !contentType.startsWith("image/")) {
            throw new RuntimeException("chỉ chấp nhận file ảnh .jpg, .png, .jpeg");
        }

        Path uploadDir = Paths.get("resources/uploads").toAbsolutePath().normalize();
        if(!Files.exists(uploadDir)) {
            try {
                Files.createDirectories(uploadDir);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String fileName = file.getOriginalFilename();
        Path newPath = uploadDir.resolve(fileName);
        try {
            file.transferTo(newPath);
            employee.setAvatarUrl(newPath.toString());
            employeeRepository.save(employee);
            return employee;
        } catch (IOException e) {
            throw new RuntimeException("Upload thất bại " + e.getMessage());
        }
    }
}
