package com.example.ex1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.model.dto.StudentDTO;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/v1/students")
public class StudentController {
    @PostMapping
    public ResponseEntity<?> createStudent(
        @Valid @RequestBody StudentDTO studentDTO,
        BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            List<String> listError = new ArrayList<>();
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                listError.add(fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(listError);
        }
        return ResponseEntity.ok("Đăng ký thành công!");
    }
}
