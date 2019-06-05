package com.medicine.domain.from;


import com.medicine.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="user对象",description="用户对象user")
public class UserForm {

    private Long id;
//
//    @ApiModelProperty(value = "账号", name = "userName", required = false)
//    private String userName;

    @ApiModelProperty(value = "账号", name = "account", required = true)
    private String account;

    private Long roleId;

    @ApiModelProperty(value = "账号", name = "userName", required = false)
    private String password;

    public static User userFormConverterUser(UserForm userForm) {
        return new User(userForm.getId(), userForm.getAccount(), userForm.getAccount(),
                userForm.getRoleId(), userForm.getPassword());
    }
}
