package com.ychs.lawfirmsys.service;

import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.Role;
import com.ychs.lawfirmsys.bean.Type;
import com.ychs.lawfirmsys.vo.LawyerNames;

import java.util.List;

public interface OptionService {
    // 查询所有的角色
    List<Role> getAllRoles();
    // 查询所有的类型
    List<Type> getAllTypes();
    // 查询所有律师姓名
    List<LawyerNames> getAllNames();
}
