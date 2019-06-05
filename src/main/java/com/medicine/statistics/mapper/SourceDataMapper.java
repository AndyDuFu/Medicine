package com.medicine.statistics.mapper;

import com.medicine.statistics.model.SourceData;

import java.util.List;

/**
 * @author: cddufu@cn.ibm.com
 * @date:
 * @desc:
 */
public interface SourceDataMapper {
    List<SourceData> getDataByGender();
    List<SourceData> getDataByAge();
    // todo 按时间段统计
    List<SourceData> getDataByChm();
    List<SourceData> getDataByWem();
    // todo 按症型统计
    List<SourceData> getDataByMedicine();
}
