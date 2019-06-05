package com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment;

import com.medicine.domain.attiendRecode.Medicine;
import com.medicine.domain.menu.Prescription;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class MedicineDTO {

    private Long id;

    // 名称
    private String name;

    // 类型
    private String liang;

    // 剂数
    private String zhuyong;

    // 医师
    private String yongfa;


    public static List<MedicineDTO> medicineDTOS(List<Medicine> medicines) {
        List<MedicineDTO> list = new ArrayList<>();
        medicines.forEach(e -> {
            MedicineDTO medicineDTO = new MedicineDTO();
            BeanUtils.copyProperties(e, medicineDTO);
            list.add(medicineDTO);
        });
        return list;
    }

    public static List<MedicineDTO> prescriptionsDTOS(List<Prescription> prescriptions) {
        List<MedicineDTO> list = new ArrayList<>();
        prescriptions.forEach(e -> {
            MedicineDTO medicineDTO = new MedicineDTO();
            medicineDTO.setId(e.getId());
            medicineDTO.setLiang(e.getYl());
            medicineDTO.setName(e.getName());
            medicineDTO.setYongfa(e.getYf());
            medicineDTO.setZhuyong(e.getZy());
            list.add(medicineDTO);
        });
        return list;
    }


}
