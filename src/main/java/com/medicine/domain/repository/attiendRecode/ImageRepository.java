package com.medicine.domain.repository.attiendRecode;

import com.medicine.domain.attiendRecode.Image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Delete(value = "delete from Image where western.id :=id")
    @Transactional
    void deleteByWesternId(@Param(value = "id") Long westernId);
}
