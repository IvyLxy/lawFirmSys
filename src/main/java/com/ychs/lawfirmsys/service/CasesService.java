package com.ychs.lawfirmsys.service;


import com.ychs.lawfirmsys.bean.Cases;
import com.ychs.lawfirmsys.vo.CaseStatistic;

import java.util.List;
import java.util.Map;

public interface CasesService {
    /**
     * 根据条件查询案件信息 (案件模块)
     * @param cases 前台传入的查询信息
     * @return 案件 集合
     */
    List<Cases> getCaseByConditions(Cases cases);

    /**
     * 不同类型的案件总数
     * @param cases 查询信息
     * @return 案件统计 集合
     */
    List<CaseStatistic> getCaseStaType(Cases cases);

    /**
     * 不同结果的案件总数
     * @param cases 案件信息
     * @return 案件统计 集合
     */
    List<CaseStatistic> getCaseStaRes(Cases cases);

    int getCaseStaTotal(Cases cases);

    List<CaseStatistic> getCaseStaTypeRes(Cases cases);

    List<Cases> getSelfCases(String realname);

    int addCases(Cases cases);

    int getClosedCaseTotal(Cases cases);
}
