package com.ychs.lawfirmsys.controller;

import com.ychs.lawfirmsys.service.OptionService;
import com.ychs.lawfirmsys.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端所有的下拉选项
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
@RestController
@RequestMapping("/opt")
public class OptionController {
    @Autowired
    private OptionService optionService;

    /**
     * 获取到所有的角色
     * @return  查询到的所有角色
     */
    @RequestMapping("/getRoles")
    public Response<?> getAllRoles(){
        return Response.success(optionService.getAllRoles());
    }

    /**
     * 获取到所有的类型 案件类型/业务特长/合同类型
     * @return  查询到的所有类型
     */
    @RequestMapping("/getTypes")
    public Response<?> getAllTypes(){
        return Response.success(optionService.getAllTypes());
    }

    /**
     * 查询到所有的律师姓名
     * @return  返回所有的律师姓名
     */
    @RequestMapping("/getLawyerName")
    public Response<?> getLawyerName(){
        return Response.success(optionService.getAllNames());
    }
}


