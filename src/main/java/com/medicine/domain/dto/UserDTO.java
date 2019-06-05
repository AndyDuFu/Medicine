package com.medicine.domain.dto;

import com.medicine.domain.User;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UserDTO {
    private Integer status;
    private User user;

    public static UserDTO converter(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setStatus(200);
        userDTO.setUser(user);
        return userDTO;
    }
}
