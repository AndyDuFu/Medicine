package com.medicine.domain.dto;

import com.medicine.domain.Attachment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDTO {

    private Long uid;

    private String name;

    private String url;
    public static ResponseDTO convert(Attachment attachment) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setName(attachment.getFileName());
        responseDTO.setUid(attachment.getId());
        responseDTO.setUrl(attachment.getFilePath());
        return responseDTO;
    }

    public static List<ResponseDTO> convert(List<Attachment> attachments) {
        List<ResponseDTO> responseDTOS = new ArrayList<>();
        attachments.forEach(e->responseDTOS.add(convert(e)));
        return responseDTOS;
    }
}
