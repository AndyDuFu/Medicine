package com.medicine.domain.repository;

import com.medicine.domain.Patient;
import com.medicine.domain.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {

    List<VisitRecord> findByPatientId(Long id);

    @Query(value = "select max(visitTimes) from VisitRecord where patient.id = ?1")
    Integer maxVisitTimes(Long id);

    List<VisitRecord> findByStatusAndPatient(Integer status, Patient patient);

}
