package com.ychs.lawfirmsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.service.UserService;
import com.ychs.lawfirmsys.util.Response;
import com.ychs.lawfirmsys.vo.LoginUser;
import com.ychs.lawfirmsys.vo.ShowUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @param user 查询条件
     * @return 响应
     */
    @RequestMapping("/query")
    public Response<?> getUserByCondition(User user){
        PageHelper.startPage(user.getPage(),user.getPageSize());
        List<User> users = userService.getUserByCondition2(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
//        List<ShowUser> users = userService.getUserByCondition(user);
//        PageInfo<ShowUser> pageInfo = new PageInfo<>(users);
        return Response.success(pageInfo);
    }

    /**
     * 添加用户
     * @param user 用户信息
     * @return 响应
     */
    @RequestMapping("/add")
    // 注意：@RequestBody 从请求体中拿数据 因为传入的是json 但需要的是实体
    public Response<?> addUser(@RequestBody User user){
        int res = userService.addUser(user);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 修改密码
     * @param user  传入的参数
     * @return 响应
     */
    @RequestMapping("/editPwd")
    public Response<?> editPwd(@RequestBody User user){
        int res = userService.editPwd(user);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 编辑用户
     * @param user 更新的用户信息
     * @return 响应
     */
    @RequestMapping("/edit")
    public Response<?> editUser(@RequestBody User user){
        int res = userService.editUser(user);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 重置密码
     * @param resetList 重置列表
     * @return 响应码
     */
    @RequestMapping("/resetPwd")
    public Response<?> resetPassword(@RequestBody Integer[] resetList){
        int res = userService.resetPassword(resetList);
        return res==resetList.length? Response.success():Response.fail();
    }

//    @RequestMapping("/delUser/{id}")
//    public Response<?> delUser(@PathVariable("id") Integer id){
//        int res = userService.delUser(id);
//        return res==1?Response.success():Response.fail();
//    }

    /**
     * 根据id删除用户
     * @param id 删除的id
     * @return 响应码
     */
    @PostMapping("/delUser")
    public Response<?> delUserV2(Integer id){
        System.out.println(id);
        int res = userService.delUser(id);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 批量删除用户
     * @param delList 删除列表
     * @return 响应
     */
    @RequestMapping("/delUsers")
    public Response<?> delUsers(@RequestBody Integer[] delList){
        int res = userService.delUsers(delList);
        System.out.println("res================>" + res);
        return res==delList.length?Response.success():Response.fail();
    }
}


