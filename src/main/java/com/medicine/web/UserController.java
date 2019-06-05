package com.medicine.web;

import com.medicine.domain.CustomerSession;
import com.medicine.domain.User;
import com.medicine.domain.dto.UserDTO;
import com.medicine.domain.dto.UserSessionDTO;
import com.medicine.domain.dto.attiendRecode.UserInfoDTO;
import com.medicine.domain.from.LoginFrom;
import com.medicine.domain.from.UserForm;
import com.medicine.domain.repository.CustomerSessionRepository;
import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;
import com.medicine.service.UserService;
import com.medicine.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/apiM/user")
@Api(value = "用户常用接口类", description = "用户登录接口")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerSessionRepository customerSessionRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ApiOperation(value="注销用户", notes="通过session")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public JsonResult logout(HttpServletRequest request) {
        HttpSession httpSession  = request.getSession();
        httpSession.removeAttribute("id");
        return JsonResult.builder().data("").build();
    }

    @ApiOperation(value="获取用户", notes="通过session")
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public UserSessionDTO getUser(HttpServletRequest request) {
        HttpSession httpSession  = request.getSession();
        Long id = (Long)httpSession.getAttribute("id");
        if (id == null) {
            throw new BusinessException(ErrorCode.AUTHORITY_ERROR);
        }
        UserSessionDTO userDTO = UserSessionDTO.converter(userService.findById(id));

        return userDTO;
    }

    @ApiOperation(value="用户登录", notes="通过用户名密码")
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginFrom loginFrom, HttpServletRequest request) {

        return userService.login(loginFrom, request);
    }

    @GetMapping("/uid")
    @ApiOperation(value = "测试")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

//    @ApiOperation(value="注册用户", notes="填写用户信息")
//    @PostMapping("/register")
//    public JsonResult register(@RequestBody UserForm userForm) {
//        if (userForm.getAccount() == null || userForm.getPassword() == null
//                || userForm.getPassword() == null
//                ){
//            return JsonResult.<String>builder().error("用户名或者密码为空").build();
//        }
////        // 密码加密 用户名+密码
////        userForm.setPassword(bCryptPasswordEncoder.
////                encode(userForm.getPassword()+userForm.getUserName()));
//
//        return JsonResult.<User>builder().data(
//                userService.save(UserForm.userFormConverterUser(userForm))
//        ).build();
//    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Page<UserSessionDTO> findAll(
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer size,
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return userService.findAll(pageRequest);
    }

    @ApiOperation(value="注册用户", notes="填写用户信息")
    @PostMapping("/save")
    public JsonResult save(@RequestBody UserForm userForm) {
        userService.save(UserForm.userFormConverterUser(userForm));
        return JsonResult.builder().data("修改成功").build();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delete")
    public JsonResult delete(@RequestParam Long id) {
        userService.delete(id);
        return JsonResult.builder().data("删除成功").build();
    }
}
