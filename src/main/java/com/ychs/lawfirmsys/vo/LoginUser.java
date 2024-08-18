package com.ychs.lawfirmsys.vo;

import lombok.Data;

import java.util.List;

/**
 * 传给前端的字段
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@Data
public class LoginUser {
    private Integer id;
    private String username;
    private String realname;

    private Integer roleId;
    private String roleName;

    private Boolean isFirstLogin;   // 判断是否为第一次登录

    private List<String> perms; // 权限
    private Long loginTime; // 登陆时间
    private Long expirationTime;    // 过期时间
}


