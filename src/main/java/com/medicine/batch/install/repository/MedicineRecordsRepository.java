package com.medicine.batch.install.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicine.batch.install.model.Medicine;

public interface MedicineRecordsRepository extends JpaRepository<Medicine, Long> {
	
	@Query(value="select * from medicine", nativeQuery=true)
	List<Medicine> getMedicineRecords();
	
}
