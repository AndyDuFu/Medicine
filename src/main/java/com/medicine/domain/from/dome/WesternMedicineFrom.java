package com.medicine.domain.from.dome;

import com.medicine.domain.attiendRecode.DiagnosisOfZh;
import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.attiendRecode.WesternMedicine;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class WesternMedicineFrom {

    private Long id;

    private String name;

    private String text;

    private List<Image> img;

    public static WesternMedicine westerFromToWester(WesternMedicineFrom westernMedicineFrom) {
        WesternMedicine westernMedicine = new WesternMedicine();
		BeanUtils.copyProperties(westernMedicineFrom, westernMedicine);
		westernMedicine.getImg().forEach(image ->{
		    image.setId(null);
		    image.setWestern(westernMedicine);
		});
        return westernMedicine;
    }
}
