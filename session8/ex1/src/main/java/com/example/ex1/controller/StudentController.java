package com.example.ex1.controller;

import com.example.ex1.exception.StudentNotFoundException;
import com.example.ex1.model.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    // dữ liệu giả lập
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("SV0001", "student1"));
        students.add(new Student("SV0002", "student2"));
        students.add(new Student("SV0003", "student3"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        for (Student student : students) {
            if(student.getId().equals(id)) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }
        throw new StudentNotFoundException("Không tồn tại sinh viên có id " + id);
    }
}
