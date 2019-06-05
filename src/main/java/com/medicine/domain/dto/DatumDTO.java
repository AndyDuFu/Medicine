package com.medicine.domain.dto;


import com.medicine.domain.Attachment;
import com.medicine.domain.Datum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class DatumDTO {

    private Long id;

    private String name;

    private String keyName;


    private List<AttachDTO> attach;


    public static DatumDTO convert(Datum datum) {
       DatumDTO datumDTO = new DatumDTO();
       BeanUtils.copyProperties(datum, datumDTO);
       datumDTO.setAttach(AttachDTO.convert(datum.getAttachments()));
       return datumDTO;
    }

    public static List<DatumDTO> convert(List<Datum> data) {
        List<DatumDTO> datumDTOS = new ArrayList<>();
        data.forEach(e->datumDTOS.add(convert(e)));
        return datumDTOS;
    }

}
