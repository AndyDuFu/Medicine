package com.medicine.domain.repository;

import com.medicine.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long>{

    List<Dictionary> findBySysType(String sysType);
}
