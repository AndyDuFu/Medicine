package com.medicine.statistics.service;

import com.medicine.statistics.model.SourceData;

import java.util.List;

/**
 * @author: cddufu@cn.ibm.com
 * @date:
 * @desc:
 */
public interface SourceDataService {
    List<SourceData> getDataByGender();
    List<SourceData> getDataByAge();
    List<SourceData> getDataByChm();
    List<SourceData> getDataByWem();
    List<SourceData> getDataByMedicine();
}
