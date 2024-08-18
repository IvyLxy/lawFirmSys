package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.Role;
import com.ychs.lawfirmsys.bean.Type;
import com.ychs.lawfirmsys.mapper.LawyerMapper;
import com.ychs.lawfirmsys.mapper.RoleMapper;
import com.ychs.lawfirmsys.mapper.TypeMapper;
import com.ychs.lawfirmsys.service.OptionService;
import com.ychs.lawfirmsys.vo.LawyerNames;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private LawyerMapper lawyerMapper;

    /**
     * 获取所有的角色信息
     * @return 查到的角色信息
     */
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    /**
     * 所有的类型信息
     * @return 查到的类型
     */
    @Override
    public List<Type> getAllTypes() {
        return typeMapper.getAllTypes();
    }

    /**
     * 查询所有的律师姓名
     * @return 只包含id 和 姓名的集合
     */
    @Override
    public List<LawyerNames> getAllNames() {
        List<Lawyer> lawyers = lawyerMapper.getAllNames();
        List<LawyerNames> lawyerNames = new ArrayList<>();  // 创建vo对象集合
        for(Lawyer lawyer: lawyers){    // 将lawyers中的值依次赋值给lawyerNames
            LawyerNames lawyerName = new LawyerNames();
            BeanUtils.copyProperties(lawyer,lawyerName);
            lawyerNames.add(lawyerName);
        }
        return lawyerNames;
    }
}


