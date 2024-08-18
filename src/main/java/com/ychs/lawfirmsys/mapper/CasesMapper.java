package com.ychs.lawfirmsys.mapper;

import com.ychs.lawfirmsys.bean.Cases;
import com.ychs.lawfirmsys.bean.Seal;
import com.ychs.lawfirmsys.dto.lawyer.LawyerSelfInfoDto;

import java.util.List;

public interface CasesMapper {
    // 1. 根据条件查询案件(案件模块)    2. 根据律师姓名查询某位律师代理的所有按键(个人信息)
    List<Cases> getCasesByCondition(Cases cases);
    // 不同类型的案件总数
    List<Cases> getCaseStaType(Cases cases);
    // 不同结果的案件总数
    List<Cases> getCaseStaRes(Cases cases);
    // 获取案件总数
    int getCaseTotal(Cases cases);

    List<Cases> getCaseStaTypeRes(Cases cases);

    // 添加案件
    int addCases(Cases cases);

    int getClosedCaseTotal(Cases cases);
}
