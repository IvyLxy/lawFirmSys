package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.bean.Menu;
import com.ychs.lawfirmsys.mapper.MenuMapper;
import com.ychs.lawfirmsys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据roleId查询菜单
     * @param roleId   前端传入的id值
     * @return  菜单集合
     */
    @Override
    public List<Menu> getMenusByRoleId(Integer roleId) {
        List<Menu> menus =  menuMapper.getMenusByRoleId(roleId);
        System.out.println(menus);

        /* 使用Stream API构建树状结构
         过滤（一级菜单） 排序（按num排序） map查找一级中的二级（递归）
         只有一个参数(可以省略 方法体只有一句话 {和return可以省略 */

        List<Menu> list = menus.stream()    // stream()方法 将menus集合转换为流（Stream）
                .filter((menu)->{   // filter()方法 对流中的元素进行过滤
                    return menu.getParentMenuId()==0;   // 筛选顶级菜单(parent_menu_id==0)
                })
                .sorted(Comparator.comparing(Menu::getNum)) // 按num排序
                .map((menu)->{  // 为每个顶级菜单设置其子菜单
                    menu.setSubs(getSub(menu,menus));
                    return menu;
                })
                .collect(Collectors.toList());
        return list;
    }

    /**
     * 递归获取子菜单
     * @param menu 一级菜单
     * @param menus 总菜单
     * @return 菜单集合
     */
    private List<Menu> getSub(Menu menu, List<Menu> menus ) {
        return menus.stream()
                .filter((m)->{
                    return m.getParentMenuId().equals(menu.getId());    // parent_menu_id=m.id
                })
                .sorted(Comparator.comparing(Menu::getNum))
                .map(m->{
                    m.setSubs(getSub(m,menus)); // 递归地为每个子菜单设置其子菜单
                    return m;
                })
                .collect(Collectors.toList());
    }
}


