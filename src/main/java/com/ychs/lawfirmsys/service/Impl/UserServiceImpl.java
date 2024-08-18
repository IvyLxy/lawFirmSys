package com.ychs.lawfirmsys.service.Impl;

import cn.hutool.core.lang.Validator;
import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.exception.BussinessException;
import com.ychs.lawfirmsys.mapper.UserMapper;
import com.ychs.lawfirmsys.service.UserService;
import com.ychs.lawfirmsys.util.JwtUtils;
import com.ychs.lawfirmsys.util.MobileNumberValidator;
import com.ychs.lawfirmsys.util.ResultCode;
import com.ychs.lawfirmsys.vo.LoginUser;
import com.ychs.lawfirmsys.vo.ShowUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(User user) {
        // 校验是username还是phone
        if(Validator.isMobile(user.getUsername())){
            // 是手机号
            user.setPhone(user.getUsername());
            user.setUsername(null);
        }
        User userSQL = userMapper.loadUser(user);
        // 没有获取到
        if(userSQL == null){
            throw new BussinessException(ResultCode.NO_LOGIN);
        }
        // 获取到 密码不对
        // password 从前台接收到的密码
        // user.getPassword 查询到的数据库中的密码
        if(!passwordEncoder.matches(user.getPassword(),userSQL.getPassword())){
            throw new RuntimeException("密码错误");
        }

        Map<String,Object> map = new HashMap<>();

        // 生成令牌 发送给前端
         // 随机生成32位标识符 用空串替换 -
        String token = UUID.randomUUID().toString().replaceAll("-","");
        // jwt + redis + token 通过token使用jwt生成一个不会重复的 jwtToken 保存到redis中
        Map<String, Object> claims = new HashMap<>();
        // 将随即生成的标识符放在jwt中的有效载荷部分 生成令牌 不好伪造
        claims.put("uuid",token);
        claims.put("username",userSQL.getUsername());
        String jwtToken = JwtUtils.createToken(claims);

        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(userSQL,loginUser);

        long currentTime = System.currentTimeMillis();
        loginUser.setLoginTime(currentTime);
        // 转换为ms
        loginUser.setExpirationTime(currentTime + 30*60*1000);

        map.put("token",jwtToken);
        map.put("user",loginUser);

        return map;
    }

    @Override
    public List<ShowUser> getUserByCondition(User user) {
        // todo
        // 查询用户
        List<User> users = userMapper.getUserByCondition(user);
        // 使用vo对象显示
        List<ShowUser> showUsers = new ArrayList<>();
        for(User u:users){
            ShowUser showUser = new ShowUser();
            BeanUtils.copyProperties(u,showUser);
            showUsers.add(showUser);
        }
        return showUsers;
    }

    @Override
    public List<User> getUserByCondition2(User user) {
        return userMapper.getUserByCondition2(user);
    }

    @Override
    public int addUser(User user) {
        // 默认密码手机号后6位
        String phone = user.getPhone();
        String pwd = phone.substring(phone.length() - 6);   //截取后6位
        String encode = passwordEncoder.encode(pwd);    //加密
        user.setPassword(encode);

        return userMapper.addUser(user);
    }

    @Override
    public int delUser(Integer delId) {
        return userMapper.delUser(delId);
    }

    @Override
    public int delUsers(Integer[] delList) {
        return userMapper.delUsers(delList);
    }

    // 修改用户
    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }
    // 修改密码
    @Override
    public int editPwd(User user) {
        if(MobileNumberValidator.validate(user.getUsername())){ // 根据user的手机号/用户名查询记录
            user.setPhone(user.getUsername());  // 是手机号 则将其赋值给phone 将username至null
            user.setUsername(null);
        }
        User userSQL = userMapper.loadUser(user);
        // 查找数据库中是否有此密码
        if(user.getPassword()!=null && !passwordEncoder.matches(user.getPassword(),userSQL.getPassword())){   // 旧密码不为空 表示用户要修改密码
            throw new RuntimeException("密码错误");
        }
        // password为空checkPass不为空 说明是用户第一次登陆修改密码 则加密赋值
        if(user.getCheckPass()!=null){
            if(passwordEncoder.matches(user.getCheckPass(),userSQL.getPassword())){   // 新旧密码一致
                throw new BussinessException(ResultCode.PWD_ERROR); // 并且和数据库中一致 新密码和旧密码重复 抛异常
            }
            String pwd = user.getCheckPass();
            String encode = passwordEncoder.encode(pwd);    //加密
            user.setCheckPass(encode);
        }
        return userMapper.editPwd(user);
    }

    @Override
    public int resetPassword(Integer[] resetList) {
        return userMapper.resetPassword(resetList);
    }
}


