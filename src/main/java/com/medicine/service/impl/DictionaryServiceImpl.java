package com.medicine.service.impl;

import com.medicine.domain.Dictionary;
import com.medicine.domain.repository.DictionaryRepository;
import com.medicine.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> findBySysType(String sysType) {
        return dictionaryRepository.findBySysType(sysType);
    }

    @Override
    public void delete(Long id) {
        dictionaryRepository.deleteById(id);
    }

    @Override
    public Dictionary save(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }
}
