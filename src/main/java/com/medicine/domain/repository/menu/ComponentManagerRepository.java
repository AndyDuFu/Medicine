package com.medicine.domain.repository.menu;

import com.medicine.domain.menu.ComponentManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentManagerRepository extends JpaRepository<ComponentManager, Long> {

    List<ComponentManager> findByNameLike(String name);
}
