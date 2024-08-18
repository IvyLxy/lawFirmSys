package com.ychs.lawfirmsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ychs.lawfirmsys.bean.Contract;
import com.ychs.lawfirmsys.bean.ContractCancel;
import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.service.ContractService;
import com.ychs.lawfirmsys.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/29
 */

@RestController
@RequestMapping("/contract")
@Slf4j
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 查询合同
     * @param contract  相关条件
     * @return  响应
     */
    @RequestMapping("/query")
    public Response<?> getContractByConditions(Contract contract){
        PageHelper.startPage(contract.getPage(),contract.getPageSize());
        List<Contract> contracts = contractService.getContractByConditions(contract);
        PageInfo<Contract> pageInfo = new PageInfo<>(contracts);
        return Response.success(pageInfo);
    }

    /**
     * 添加合同
     * @param contract  前台传入 Post请求
     * @return 响应
     */
    @RequestMapping("/add")
    public Response<?> addContract(@RequestBody Contract contract){
        int res = contractService.addContract(contract);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 合同注销
     * @param contractCancel 前台传入
     * @return 响应
     */
    @RequestMapping("/cancel")
    public Response<?> cancelContract(@RequestBody ContractCancel contractCancel){
        log.info("ContractController:{}",contractCancel);
        int res = contractService.cancelContract(contractCancel);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 查询注销合同
     * @param contractCancel 查询条件
     * @return 响应
     */
    @RequestMapping("/queryCancel")
    public Response<?> getCancelContractByConditions(ContractCancel contractCancel){
        log.info("ContractController:{}",contractCancel);
        PageHelper.startPage(contractCancel.getPage(),contractCancel.getPageSize());
        List<ContractCancel> contracts = contractService.getCancelContractByConditions(contractCancel);
        PageInfo<ContractCancel> pageInfo = new PageInfo<>(contracts);
        return Response.success(pageInfo);
    }
}


