package com.medicine.domain.repository;

import com.medicine.domain.Attachment;
import com.medicine.domain.Datum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Long>{

    @Select(value = "select * from Attachment where datum.id =:id")
    List<Attachment> findByDatumId(@Param(value = "id") Long id);
}
