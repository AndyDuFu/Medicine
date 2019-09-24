package com.medicine.batch.install.repository;

import com.medicine.batch.install.model.OMRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: cddufu@cn.ibm.com
 * @date: 2019-09-24
 */
public interface OMRepository extends JpaRepository<OMRecord, Long> {
}
