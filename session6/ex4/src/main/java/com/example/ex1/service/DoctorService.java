package com.example.ex1.service;

import com.example.ex1.model.entity.Doctor;
import com.example.ex1.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    // lấy danh sách doctor
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    // thêm doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // xóa doctor
    public boolean deleteDoctor(Long deleteId) {
        if(doctorRepository.existsById(deleteId)) {
            doctorRepository.deleteById(deleteId);
            return true;
        } else {
            return false;
        }
    }

    // sửa thông tin doctor
    public Optional<Doctor> updateDoctor(Long id, Doctor doctor) {
        if(doctorRepository.existsById(id)) {
            return Optional.of(doctorRepository.save(doctor));
        } else {
            return Optional.empty();
        }
    }
}
