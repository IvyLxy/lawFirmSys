package com.ychs.lawfirmsys.service;

public interface ToolService {
    // 电话 唯一性校验
    int findMobile(String phone);
    // 用户名 唯一性校验
    int findUsername(String username);
}
