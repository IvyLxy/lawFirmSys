package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserMapper {
    // 根据输入的username/phone-->看数据库中是否含有该user的信息-->loadUserByUsername获取user的全部信息

    // todo 如何合并在一起
    User loadUserByUsername(String param);

    User loadUser(User user);

    // 查询所有的用户信息 vo对象
    List<User> getUserByCondition(User user);
    // 查询所有的用户信息
    List<User> getUserByCondition2(User user);

    // 查询所拥有的菜单权限

    // 添加用户
    int addUser(User user);

    // 禁用用户

    // 启用用户

    // 重置用户密码

    // 删除用户
    int delUser(Integer delId);
    // 批量删除用户
    int delUsers(Integer[] delList);
    // todo 编辑用户 禁用启用能否写在一起？
    int editPwd(User user);

    int resetPassword(Integer[] resetList);

    // 判断手机号是否唯一
    int findMobile(String phone);
    // 判断用户名是否唯一
    int findUsername(String username);

    // 添加律师的同时 添加用户
    int addLawyer(User user);

    int editUser(User user);
}
