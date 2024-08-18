package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.util.List;

/**
 * 菜单
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
@Data
public class Menu {
    private Integer id; // id
    private String title;   // 菜单名称
    private String index;   // 路由地址
    private Integer parentMenuId; // 父id
    private String privilege;
    private String icon;    // 图标
    private Integer num;    // 同级别排序
    private String type;    // 区分权限类型   D目录 B按钮 M菜单

    private List<Menu> subs;    // 子菜单
}


