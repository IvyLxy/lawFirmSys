package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.Menu;

import java.util.List;

public interface MenuService {
    // 根据roleId查询菜单
    List<Menu> getMenusByRoleId(Integer roleId);
}
