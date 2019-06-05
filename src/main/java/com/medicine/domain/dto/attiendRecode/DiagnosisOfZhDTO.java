package com.medicine.domain.dto.attiendRecode;

import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.AskDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.LookDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.WqDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.ZhaiyaoDTO;
import lombok.Data;

@Data
public class DiagnosisOfZhDTO {

    private Long id;

    private AskDTO ask;

    private LookDTO look;

    private WqDTO wq;

    private ZhaiyaoDTO zhaiyao;
}
