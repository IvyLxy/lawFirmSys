package com.ychs.lawfirmsys.service.Impl;

import com.ychs.lawfirmsys.bean.Cases;
import com.ychs.lawfirmsys.mapper.CasesMapper;
import com.ychs.lawfirmsys.service.CasesService;
import com.ychs.lawfirmsys.vo.CaseStatistic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/1
 */
@Service
public class CasesServiceImpl implements CasesService {
    @Autowired
    private CasesMapper casesMapper;
    // 遍历获取vo对象
    public List<CaseStatistic> getVO(List<Cases> casesList){
        List<CaseStatistic> staList = new ArrayList<>();
        for (Cases c : casesList) {
            CaseStatistic statistic = new CaseStatistic();
            BeanUtils.copyProperties(c,statistic);
            staList.add(statistic);
        }
        System.out.println(staList);
        return staList;
    }



    @Override
    public List<Cases> getCaseByConditions(Cases cases) {
        return casesMapper.getCasesByCondition(cases);
    }

    @Override
    public List<CaseStatistic> getCaseStaType(Cases cases) {
        List<Cases> casesList = casesMapper.getCaseStaType(cases);
        return getVO(casesList);
    }

    @Override
    public List<CaseStatistic> getCaseStaRes(Cases cases) {
        List<Cases> casesList = casesMapper.getCaseStaRes(cases);
        System.out.println(casesList);

        List<Cases> cases1 = new ArrayList<>();

        Cases case1 = new Cases();
        case1.setResult("胜诉");
        case1.setResTotal(0);
        cases1.add(case1);
        Cases case2 = new Cases();
        case2.setResult("败诉");
        case2.setResTotal(0);
        cases1.add(case2);
        Cases case3 = new Cases();
        case3.setResult("调解");
        case3.setResTotal(0);
        cases1.add(case3);

        for (int i = 0; i < cases1.size(); i++) {
            for (Cases cases2 : casesList) {
                if (cases1.get(i).getResult().equals(cases2.getResult())) {
                    cases1.get(i).setResTotal(cases2.getResTotal());
                }
            }
        }
        System.out.println(cases1);
        return getVO(cases1);
    }

    @Override
    public int getCaseStaTotal(Cases cases) {
        return casesMapper.getCaseTotal(cases);
    }

    @Override
    public List<CaseStatistic> getCaseStaTypeRes(Cases cases) {
        List<Cases> casesList = casesMapper.getCaseStaTypeRes(cases);
        return getVO(casesList);
    }

    @Override
    public List<Cases> getSelfCases(String realname) {
        Cases cases = new Cases();
        cases.setLawyerName(realname);  // 为了可以使用同一条sql语句
        return casesMapper.getCasesByCondition(cases);
    }

    @Override
    public int addCases(Cases cases) {
        return casesMapper.addCases(cases);
    }

    @Override
    public int getClosedCaseTotal(Cases cases) {
        return casesMapper.getClosedCaseTotal(cases);
    }
}


