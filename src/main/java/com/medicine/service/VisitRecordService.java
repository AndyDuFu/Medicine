package com.medicine.service;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.PatientRecodDTO;
import com.medicine.domain.dto.YiAnReCodDTO;
import com.medicine.domain.from.VisitRecordForm;
import com.medicine.domain.from.YiAnForm;
import com.medicine.domain.queryFrom.YanQueryFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface VisitRecordService {

    VisitRecord save(VisitRecordForm visitRecordForm);

    PatientRecodDTO findById(Long id);

    Page<YiAnReCodDTO> findByNameAndVisitDate(Pageable pageable, String name, String visitDate);

    Long patiendSave(YiAnReCodDTO yiAnReCodDTO) ;

    void editYianRecode(YiAnForm yiAnFrom);

    void setYiyan(Long id);

//    Page<Map<String, Object>>


    List<YiAnReCodDTO> findALl(YanQueryFrom yanQueryFrom);
    
    // 批量导入病患就诊记录
    void batchInstall(List<VisitRecordForm> visitRecordForms);
}
