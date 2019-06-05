package com.medicine.service;

import com.medicine.domain.Dictionary;

import java.util.List;

public interface DictionaryService {

    List<Dictionary> findBySysType(String sysType);

    void delete(Long id);

    Dictionary save(Dictionary dictionary);
}
