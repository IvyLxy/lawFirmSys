package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.vo.LoginUser;
import com.ychs.lawfirmsys.vo.ShowUser;

import java.util.List;
import java.util.Map;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
public interface UserService {
    // 登录 电话正则校验
    Map<String,Object> login(User user);

    // 查询 vo对象
    List<ShowUser> getUserByCondition(User user);
    // 查询
    List<User> getUserByCondition2(User user);


    // 添加用户
    int addUser(User user);
    // 删除用户
    int delUser(Integer delId);
    // 删除选中的用户
    int delUsers(Integer[] delList);
    // 编辑用户
    int editUser(User user);
    // 编辑密码
    int editPwd(User user);
    // 重置用户密码
    int resetPassword(Integer[] resetList);
}


