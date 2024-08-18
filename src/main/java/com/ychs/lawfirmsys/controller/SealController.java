package com.ychs.lawfirmsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ychs.lawfirmsys.bean.Seal;
import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.mapper.SealMapper;
import com.ychs.lawfirmsys.service.SealService;
import com.ychs.lawfirmsys.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/31
 */
@RestController
@RequestMapping("/seal")
public class SealController {
    @Autowired
    private SealService sealService;

    /**
     * 查询用章信息
     * @param seal 查询信息
     * @return 响应
     */
    @RequestMapping("/query")
    public Response<?> getSealByCondition(Seal seal){
        PageHelper.startPage(seal.getPage(),seal.getPageSize());
        List<Seal> seals = sealService.getSealByCondition(seal);
        PageInfo<Seal> pageInfo = new PageInfo<>(seals);
        return Response.success(pageInfo);
    }

    /**
     * 添加用章信息
     * @param seal 相关信息
     * @return 响应
     */
    @RequestMapping("/add")
    public Response<?> addSeal(@RequestBody Seal seal){
        int res = sealService.addSeal(seal);
        return res==1?Response.success():Response.fail();
    }
}


