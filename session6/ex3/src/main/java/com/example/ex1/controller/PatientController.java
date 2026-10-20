package com.example.ex1.controller;

import com.example.ex1.model.entity.Patient;
import com.example.ex1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    // lấy danh sách patient
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

    // thêm mới patient
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    // xóa patient
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        if(patientService.deletePatient(id)) {
            return new ResponseEntity<>("Xóa thành công!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id không tồn tại!", HttpStatus.NOT_FOUND);
        }
    }
}
