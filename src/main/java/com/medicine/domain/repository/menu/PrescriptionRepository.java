package com.medicine.domain.repository.menu;

import com.medicine.domain.menu.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByMenuId(Long menuId);
}
