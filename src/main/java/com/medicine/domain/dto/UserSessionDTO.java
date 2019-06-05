package com.medicine.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.medicine.domain.User;
import com.medicine.util.Date2LongSerializer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class UserSessionDTO {

    private Long id;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createDate;

    private String account;
    private Long roleId;
    private Integer status;

    public static UserSessionDTO converter(User user) {
        UserSessionDTO userDTO = new UserSessionDTO();
        BeanUtils.copyProperties(user, userDTO);
        userDTO.setStatus(200);
        return userDTO;
    }
}
