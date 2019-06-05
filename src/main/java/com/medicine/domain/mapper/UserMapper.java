package com.medicine.domain.mapper;


import com.medicine.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    int countByUsername(String username);

    @Select("select count(*) from t_user where account = #{account}")
    int countByAccount(String account);

}
