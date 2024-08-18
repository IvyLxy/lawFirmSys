package com.ychs.lawfirmsys.service.Impl;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.ychs.lawfirmsys.bean.*;
import com.ychs.lawfirmsys.dto.lawyer.LawyerSelfInfoDto;
import com.ychs.lawfirmsys.mapper.CasesMapper;
import com.ychs.lawfirmsys.mapper.LawyerMapper;
import com.ychs.lawfirmsys.mapper.UserMapper;
import com.ychs.lawfirmsys.service.LawyerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/28
 */
@Service
public class LawyerServiceImpl implements LawyerService {
    @Autowired
    private LawyerMapper lawyerMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CasesMapper casesMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Lawyer> getLawyersByCondition(Lawyer lawyer) {
        return lawyerMapper.getLawyersByCondition(lawyer);
    }

    @Override
    public int editLawyer(Lawyer lawyer) {
        return lawyerMapper.editLawyer(lawyer);
    }

    @Override
    @Transactional
    public int addLawyer(Lawyer lawyer) {
        // 律师表添加
        int res1 = lawyerMapper.addLawyer(lawyer);

        // 默认密码手机号后6位
        String phone = lawyer.getPhone();
        String pwd = phone.substring(phone.length() - 6);   //截取后6位
        String encode = passwordEncoder.encode(pwd);    //加密

        User user = new User();
        BeanUtils.copyProperties(lawyer,user);

        user.setUsername( PinyinUtil.getPinyin(lawyer.getLawyerName(),""));   // 用户名赋值 默认是真实姓名全拼
        user.setRealname(lawyer.getLawyerName());   // 真实姓名赋值
        user.setPassword(encode);   // 赋值密码
        user.setRoleId(2);  // 赋值律师id
        user.setState(true);    // 默认启用
        user.setIsFirstLogin(true);     //  默认第一次登陆
        System.out.println("赋值之后的user=====================》"+user);
        // user表添加
        int res2 = userMapper.addLawyer(user);

        return res1&res2;
    }

    @Override
    public Lawyer getSelfInfo(String realname) {
        Lawyer lawyer = lawyerMapper.getSelfInfo(realname);
        System.out.println(lawyer);
        return lawyer;
    }
    @Override
    public Map<String, List<?>> getSelfInfoV2(LawyerSelfInfoDto selfInfoDto) {

        Map<String, List<?>> map = new HashMap<>();

        // 荣誉
        List<Awards> awards = lawyerMapper.getAwards(selfInfoDto);
        // 处罚
        List<Punishment> punishment = lawyerMapper.getPunishment(selfInfoDto);
        // 案件 想共用一条sql 所以new了一个case对象
        Cases cases1 = new Cases();
        cases1.setLawyerName(selfInfoDto.getRealname());
        List<Cases> cases = casesMapper.getCasesByCondition(cases1);

        map.put("awards",awards);
        map.put("punishment",punishment);
        map.put("cases",cases);

        System.out.println(map);
        return map;
    }
}


