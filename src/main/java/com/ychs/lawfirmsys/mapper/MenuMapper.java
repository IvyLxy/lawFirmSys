package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Menu;

import java.util.List;

public interface MenuMapper {
    // 根据roleId获取菜单
    List<Menu> getMenusByRoleId(Integer roleId);
}
