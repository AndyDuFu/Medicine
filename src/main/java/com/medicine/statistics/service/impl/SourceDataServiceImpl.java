package com.medicine.statistics.service.impl;

import com.medicine.statistics.mapper.SourceDataMapper;
import com.medicine.statistics.model.SourceData;
import com.medicine.statistics.service.SourceDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: cddufu@cn.ibm.com
 * @date:
 * @desc:
 */
@Service
@Transactional
public class SourceDataServiceImpl implements SourceDataService {
    @Resource
    private SourceDataMapper countMapper;

    @Override
    public List<SourceData> getDataByGender() {
        return countMapper.getDataByGender();
    }

    @Override
    public List<SourceData> getDataByAge() {
        return countMapper.getDataByAge();
    }

    @Override
    public List<SourceData> getDataByChm() {
        return countMapper.getDataByChm();
    }

    @Override
    public List<SourceData> getDataByWem() {
        return countMapper.getDataByWem();
    }

    @Override
    public List<SourceData> getDataByMedicine() {
        return countMapper.getDataByMedicine();
    }
}
