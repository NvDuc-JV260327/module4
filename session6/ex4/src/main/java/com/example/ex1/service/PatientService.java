package com.example.ex1.service;

import com.example.ex1.model.dto.PaginationResponse;
import com.example.ex1.model.entity.Patient;
import com.example.ex1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    // phân trang và tìm kiếm theo tên
    public Page<Patient> findAllAndSearch(Pageable pageable, String patientName) {
        return patientRepository.findAllByFullNameContainingIgnoreCase(patientName, pageable);
    }

    // tìm kiếm bệnh nhân
    public PaginationResponse searchPatients(String patientName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> page1 = findAllAndSearch(pageable, patientName);
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setData(page1.getContent());
        paginationResponse.setTotalPage(page1.getTotalPages());
        paginationResponse.setCurrentPage(page1.getNumber());
        paginationResponse.setTotalElement(page1.getTotalElements());
        return paginationResponse;
    }
}
