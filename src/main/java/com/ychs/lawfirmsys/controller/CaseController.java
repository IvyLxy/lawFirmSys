package com.ychs.lawfirmsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ychs.lawfirmsys.bean.Cases;
import com.ychs.lawfirmsys.service.CasesService;
import com.ychs.lawfirmsys.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 案件 控制层
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/1
 */
@RestController
@RequestMapping("/cases")
public class CaseController {
    @Autowired
    private CasesService casesService;

    /**
     * 根据条件查询案件信息 (案件模块)
     * @param cases 前台传入的查询信息
     * @return 响应码 案件信息
     */
    @RequestMapping("/query")
    public Response<?> getCaseByCondition(Cases cases){
        PageHelper.startPage(cases.getPage(),cases.getPageSize());  // 接收的是前端传入的值
        List<Cases> contracts = casesService.getCaseByConditions(cases);
        PageInfo<Cases> pageInfo = new PageInfo<>(contracts);
        return Response.success(pageInfo);
    }

    /**
     * 根据真实姓名查询个人案件信息 (个人信息)
     * @param realname 前台传入的真实姓名/律师姓名
     * @return  响应码 个人信息
     */
    @RequestMapping("/getSelfCases")
    public Response<?> getSelfCases(String realname){
        return Response.success(casesService.getSelfCases(realname));
    }

    /**
     * 不同类型的案件总数
     * @param cases 前台传入的信息
     * @return 响应
     */
    @RequestMapping("/staType")
    public Response<?> getCaseStaType(Cases cases){
        return Response.success(casesService.getCaseStaType(cases));
    }

    /**
     * 不同结果的案件总数
     * @param cases 前台传入的信息
     * @return 响应
     */
    @RequestMapping("/staRes")
    public Response<?> getCaseStaRes(Cases cases){
        return Response.success(casesService.getCaseStaRes(cases));
    }

    /**
     * 获取案件总数
     * @param cases 前台传入的信息
     * @return 响应
     */
    @RequestMapping("/staTotal")
    public Response<?> getCaseStaTotal(Cases cases){
        return Response.success(casesService.getCaseStaTotal(cases));
    }

    /**
     * 获取已结案的案件总数
     * @param cases 前台传入的信息
     * @return 响应
     */
    @RequestMapping("/staClosedTotal")
    public Response<?> getClosedCaseTotal(Cases cases){
        return Response.success(casesService.getClosedCaseTotal(cases));
    }

    /**
     * 每种类型的结果分布 (柱状图)
     * @param cases 前台传入
     * @return 响应
     */
    @RequestMapping("/staTypeRes")
    public Response<?> getCaseStaTypeRes(Cases cases){
        return Response.success(casesService.getCaseStaTypeRes(cases));
    }

    /**
     * 添加案件信息
     * @param cases 前台传入的cases信息 post请求 接收到的时JSON字符串 故需要添加@RequestBody
     * @return  响应给前台的状态码
     */
    @RequestMapping("/add")
    public Response<?> addCases(@RequestBody Cases cases){
        System.out.println(cases);
        int res = casesService.addCases(cases);
        return res==1?Response.success():Response.fail();
    }
}


