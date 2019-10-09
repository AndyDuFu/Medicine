package com.medicine.batch.install.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.medicine.batch.install.model.Medicine;
import org.springframework.data.repository.query.Param;

public interface MedicineRecordsRepository extends JpaRepository<Medicine, Long> {
	
	@Query(value="select * from medicine", nativeQuery=true)
	List<Medicine> getMedicineRecords();

	@Query(value = "delete from medicine where dat_id = :datid", nativeQuery = true)
	@Modifying
	void deleteAllByDatid(@Param("datid") long datid);
	
}
