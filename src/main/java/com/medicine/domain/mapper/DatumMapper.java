package com.medicine.domain.mapper;

import com.medicine.domain.Datum;
import com.medicine.domain.dto.DatumDTO;
import com.medicine.domain.menu.PlatformManagerData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface DatumMapper extends BaseMapper<Datum> {

    List<DatumDTO> findByList(@Param("title")String title, @Param("key")String key);
}
