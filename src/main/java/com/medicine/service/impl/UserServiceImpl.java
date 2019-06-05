package com.medicine.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicine.data.UserType;
import com.medicine.domain.CustomerSession;
import com.medicine.domain.User;
import com.medicine.domain.dto.UserDTO;
import com.medicine.domain.dto.UserSessionDTO;
import com.medicine.domain.from.LoginFrom;
import com.medicine.domain.mapper.UserMapper;
import com.medicine.domain.repository.CustomerSessionRepository;
import com.medicine.domain.repository.UserRepository;
import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;
import com.medicine.service.UserService;
import com.medicine.util.PooledStrongPasswordEncryptor;
import com.medicine.util.SecureTokenhelper;


@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerSessionRepository customerSessionRepository;
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public int countByAccount(String account) {
        return userMapper.countByAccount(account);
    }

    @Override
    public User findUserByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public User save(User user) {
        validateCommonRegisterAccountInfo(user);
        Date date = new Date();
        if (user.getId() != null) {
            User u = new User();
            u.setId(user.getId());
            User currentUser = userRepository.findOne(Example.of(u)).get();
            if (StringUtils.isNotEmpty(user.getPassword())) {
                currentUser.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(user.getPassword()));
            }
            currentUser.setRoleId(user.getRoleId());
            currentUser.setUpdateDate(date);
            return userRepository.save(currentUser);
        }
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(user.getPassword()));
        user.setCreateDate(date);
        user.setUpdateDate(date);
        return userRepository.save(user);
    }

    private void validateCommonRegisterAccountInfo(User user) {
        if (StringUtils.isBlank(user.getAccount())) {
            throw new BusinessException(ErrorCode.USERNAME_PATTERN_ERROR);
        }
        User u = userRepository.findByAccount(user.getAccount());
        if (u != null) {
            if (user.getId() == null) {
                throw new BusinessException(ErrorCode.ACCOUNT_NAME_USED);
            }
        }
    }


    @Override
    public UserDTO login(LoginFrom loginFrom, HttpServletRequest request) {
        User user = userRepository.findByAccount(loginFrom.getName());
        if (user == null) {
            throw new BusinessException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }
        if (!PooledStrongPasswordEncryptor.getInstance().checkPassword(loginFrom.getPassword(),
                user.getPassword())) {
            throw new BusinessException(ErrorCode.USERNAME_OR_PASSWORD_ERROR);
        }
        String token = SecureTokenhelper.createToken(UserType.CUSTOMER);
        CustomerSession session = new CustomerSession();
        session.setAuthToken(token);
        session.setStartTime(new Date());
        session.setExpired(false);
        session.setUser(user);
        session = customerSessionRepository.save(session);
        customerSessionRepository.save(session);
        HttpSession httpSession  = request.getSession();
        httpSession.setAttribute("id", user.getId());
        httpSession.setMaxInactiveInterval(60*60);
        UserDTO userDTO = UserDTO.converter(user);

        logger.info("User login system: " + loginFrom);
        
        return userDTO;
    }

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        return userRepository.findOne(Example.of(user)).get();
    }

    @Override
    public Page<UserSessionDTO> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        List<UserSessionDTO> userSessionDTOS = new ArrayList<>();
        List<User> users = page.getContent();
        users.forEach(e-> userSessionDTOS.add(UserSessionDTO.converter(e)));
        return new PageImpl(userSessionDTOS, pageable, page.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
