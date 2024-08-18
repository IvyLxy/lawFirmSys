package com.ychs.lawfirmsys.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * User类
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@Data
public class User extends PageEntity {
    private Integer id;
    private String username;
    private String realname;

    private String password;    // 初始密码
    private String phone;
    private Integer roleId;

    private Boolean state;   //标记是否启用 默认true 启用

    private Boolean isFirstLogin;   // 判断是否为第一次登录

    private String roleName;

    private String pass;    // 修改密码
    private String checkPass;   // 二次确认
}


