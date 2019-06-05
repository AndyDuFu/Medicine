package com.medicine.service;

import com.medicine.domain.User;
import com.medicine.domain.dto.UserDTO;
import com.medicine.domain.dto.UserSessionDTO;
import com.medicine.domain.from.LoginFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<User> findAll();

    int countByAccount(String account);

    User findUserByUserName(String name);

    User save(User user);

    UserDTO login(LoginFrom loginFrom, HttpServletRequest request);

    User findById(Long id);

    Page<UserSessionDTO> findAll(Pageable pageable);

    void delete(Long id);
}
