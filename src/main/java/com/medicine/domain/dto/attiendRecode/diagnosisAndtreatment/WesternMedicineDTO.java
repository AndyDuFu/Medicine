package com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment;

import com.medicine.domain.attiendRecode.Image;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WesternMedicineDTO {

    private Long id = -1L;

    private String text = "";

    private List<ImageDTO> img = new ArrayList<>();
}
