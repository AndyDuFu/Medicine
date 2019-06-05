package com.medicine.domain.repository;

import com.medicine.domain.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByNameLike(String name, Pageable pageable);

    List<Patient> findByPhone(String phone);
}
