package com.medicine.service;

import com.medicine.domain.menu.ComponentManager;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ComponentManagerService {

    List<ComponentManager> findByName(String name);

    ComponentManager save(ComponentManager componentManager);

    void delete(Long id);
}
