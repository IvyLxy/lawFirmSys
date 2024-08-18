package com.ychs.lawfirmsys.controller;

import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.mapper.RoleMapper;
import com.ychs.lawfirmsys.service.UserService;
import com.ychs.lawfirmsys.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user 传入的用户参数
     * @return 响应 将token 和 user 传给前端
     */
    @RequestMapping("/login")
    public Response<Map<String,Object>> login(User user){
        System.out.println(user);
        Map<String,Object> map = userService.login(user);
        return Response.success(map);
    }
}


