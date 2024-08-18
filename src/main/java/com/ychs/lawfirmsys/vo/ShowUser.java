package com.ychs.lawfirmsys.vo;

import lombok.Data;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
@Data
public class ShowUser {
    private Integer id;
    private String username;
    private String phone;
    private String realname;
    private String roleName;
    private Boolean state;
}


