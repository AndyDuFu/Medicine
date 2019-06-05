package com.medicine.service;

import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.MedicineDTO;
import com.medicine.domain.dto.count.StatementDTO;
import com.medicine.domain.dtoAndFrom.menu.FjManager;
import com.medicine.domain.dtoAndFrom.menu.ZyManager;
import com.medicine.domain.menu.PlatformManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.ZyQueryFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PlatformManagerService {
    PlatformManager save(Map<String, Object> data);

    List<Map<String, Object>> findByManager(String type);

    void deletePlatAndPlatDate(Long id);

    List<String> findByZyName();

    List<PlatformManagerData> findZhongYi(ZyQueryFrom zyQueryFrom);
    
    List<PlatformManagerData> findZhongYiByLike(ZyQueryFrom zyQueryFrom);

    List<FjManager> findFj(FJQueryFrom fjQueryFrom);
    
    List<FjManager> likeByFj(FJQueryFrom fjQueryFrom);

    List<StatementDTO> countData(FJQueryFrom fjQueryFrom, Integer type);

    // 方剂主治
    List<MedicineDTO> findByFJZI(Integer status, Long mid);
}
