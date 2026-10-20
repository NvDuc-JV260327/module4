package com.example.ex1.service;

import com.example.ex1.model.entity.Patient;
import com.example.ex1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    // lấy ds patient
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    // thêm mới patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // xóa patient theo id
    public boolean deletePatient(Long deleteId) {
        if(patientRepository.existsById(deleteId)) {
            patientRepository.deleteById(deleteId);
            return true;
        } else {
            return false;
        }
    }

}
