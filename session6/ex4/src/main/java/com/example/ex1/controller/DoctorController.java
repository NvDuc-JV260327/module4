package com.example.ex1.controller;

import com.example.ex1.model.entity.Doctor;
import com.example.ex1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    // lấy danh sách doctor
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctor(), HttpStatus.OK);
    }

    // thêm doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
    }

    // xóa doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        if(doctorService.deleteDoctor(id)) {
            return new ResponseEntity<>("Xóa thành công!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id không tồn tại!", HttpStatus.NOT_FOUND);
        }
    }

    // sửa thông tin doctor
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Optional<Doctor> optionalDoctor = doctorService.updateDoctor(id, doctor);
        if(optionalDoctor.isEmpty()) {
            return new ResponseEntity<>("Id không tồn tại!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(optionalDoctor, HttpStatus.OK);
        }
    }
}
