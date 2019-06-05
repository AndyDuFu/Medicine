package com.medicine.domain.repository;

import com.medicine.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserName(String username);

    User findByAccount(String account);
}
