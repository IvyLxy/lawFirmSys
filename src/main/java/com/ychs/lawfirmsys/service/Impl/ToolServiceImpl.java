package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.mapper.LawyerMapper;
import com.ychs.lawfirmsys.mapper.UserMapper;
import com.ychs.lawfirmsys.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 电话 唯一性校验
     * @param phone 电话
     * @return 在数据库中查到的个数
     */
    @Override
    public int findMobile(String phone) {
       return userMapper.findMobile(phone);
    }

    /**
     * 用户名 唯一性校验
     * @param username 用户名
     * @return 在数据库中查到的个数
     */
    @Override
    public int findUsername(String username) {
        return userMapper.findUsername(username);
    }
}


