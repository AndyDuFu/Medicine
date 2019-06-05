package com.medicine.domain.dto.attiendRecode;

import com.medicine.domain.dto.VisitRecordDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataDTO implements Serializable {
    private List<VisitRecordDTO> data;
}
