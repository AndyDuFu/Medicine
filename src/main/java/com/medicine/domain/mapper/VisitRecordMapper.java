package com.medicine.domain.mapper;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.dtoAndFrom.menu.FjManager;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.YanQueryFrom;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

public interface VisitRecordMapper extends BaseMapper<VisitRecord> {

    List<VisitRecord> findAll(YanQueryFrom yanQueryFrom);


}
