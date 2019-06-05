package com.medicine.domain.repository;

import com.medicine.domain.CustomerSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSessionRepository extends JpaRepository<CustomerSession, Long> {
}
