package com.ychs.lawfirmsys.controller;

import com.ychs.lawfirmsys.service.ToolService;
import com.ychs.lawfirmsys.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
@RestController
@RequestMapping("/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;

    /**
     * 电话 唯一性校验
     * @param phone 前台传入的电话
     * @return 响应码
     */
    @RequestMapping("/checkMobileUnique")
    public Response<?> CheckMobileUnique(String phone){
        int res = toolService.findMobile(phone);
        return res>0?Response.fail():Response.success();
    }

    /**
     * 用户名 唯一性校验
     * @param username 前台传入的用户名
     * @return 响应码
     */
    @RequestMapping("/checkUsernameUnique")
    public Response<?> CheckUsernameUnique(String username){
        int res = toolService.findUsername(username);
        // 没有找到就成功
        return res>0?Response.fail():Response.success();
    }
}


