package com.medicine.service.impl;

import com.medicine.domain.menu.ComponentManager;
import com.medicine.domain.repository.menu.ComponentManagerRepository;
import com.medicine.service.ComponentManagerService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ComponentManagerServiceImpl implements ComponentManagerService {

    @Autowired
    private ComponentManagerRepository componentManagerRepository;

    @Override
    public List<ComponentManager> findByName(String name) {
        return StringUtils.isEmpty(name)?componentManagerRepository.findAll():componentManagerRepository.findByNameLike(name);
    }

    @Override
    public ComponentManager save(ComponentManager componentManager) {
        return componentManagerRepository.save(componentManager);
    }

    @Override
    public void delete(Long id) {
        componentManagerRepository.deleteById(id);
    }
}
