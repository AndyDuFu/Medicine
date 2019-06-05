package com.medicine.domain.repository.attiendRecode;

import com.medicine.domain.attiendRecode.Medicine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    @Delete(value = "delete from Medicine where dat.id :=id")
    @Transactional
    void deleteByDatId(@Param(value = "id") Long id);

    List<Medicine> findByDatId(Long id);
}
