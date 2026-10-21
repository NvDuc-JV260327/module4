package com.example.ex1.repository;

import com.example.ex1.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByFullName(String fullName, Pageable pageable);

    Page<Patient> findAllByFullNameContainingIgnoreCase(String fullName, Pageable pageable);
}
