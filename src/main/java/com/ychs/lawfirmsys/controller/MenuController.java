package com.ychs.lawfirmsys.controller;

import com.ychs.lawfirmsys.bean.Menu;
import com.ychs.lawfirmsys.service.MenuService;
import com.ychs.lawfirmsys.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单 控制层
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 根据roleId查询菜单
     * @param roleId 前台传入的角色id
     * @return  菜单信息
     */
    @RequestMapping("/getMenusByRoleId")
    public Response<?> getMenusByRoleId(Integer roleId){
        List<Menu> menus =menuService.getMenusByRoleId(roleId);
        return Response.success(menus);
    }
}


