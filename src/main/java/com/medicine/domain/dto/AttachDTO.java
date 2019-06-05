package com.medicine.domain.dto;

import com.medicine.domain.Attachment;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class AttachDTO {

    private Long uid;

    private String name;

    private String url;

    public static AttachDTO convert(Attachment attachment) {
        AttachDTO attachDTO = new AttachDTO();
        attachDTO.setName(attachment.getFileName());
        attachDTO.setUid(attachment.getId());
        attachDTO.setUrl(attachment.getFilePath());
        return attachDTO;
    }

    public static List<AttachDTO> convert(List<Attachment> attachments) {
        List<AttachDTO> attachDTOS = new ArrayList<>();
        attachments.forEach(e->attachDTOS.add(convert(e)));
        return attachDTOS;
    }
}
