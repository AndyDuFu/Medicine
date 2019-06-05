package com.medicine.domain.converter;

import com.medicine.domain.attiendRecode.Medicine;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.MedicineDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class MedicineToMedicineDTO {

    public static MedicineDTO converter(Medicine medicine) {
        MedicineDTO medicineDTO = new MedicineDTO();
        BeanUtils.copyProperties(medicine, medicineDTO);
        return medicineDTO;
    }

    public static List<MedicineDTO> converter(List<Medicine> medicines) {
        List<MedicineDTO> medicineDTOS = new ArrayList<>();
        medicines.forEach(e -> medicineDTOS.add(converter(e)));
        return medicineDTOS;
    }
}
