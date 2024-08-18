package com.ychs.lawfirmsys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ychs.lawfirmsys.bean.Awards;
import com.ychs.lawfirmsys.bean.Lawyer;
import com.ychs.lawfirmsys.bean.User;
import com.ychs.lawfirmsys.dto.lawyer.LawyerSelfInfoDto;
import com.ychs.lawfirmsys.service.LawyerService;
import com.ychs.lawfirmsys.util.Response;
import com.ychs.lawfirmsys.util.UUIDutilsu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/28
 */
@RestController
@RequestMapping("/lawyer")
@Slf4j
public class LawyerController {
    @Autowired
    private LawyerService lawyerService;
    /**
     * 根据前台传入的条件查询律师信息
     * @param lawyer 前台传入的条件 即this.query
     * @return 响应
     */
    @RequestMapping("/query")
    public Response<?> getLawyersByCondition(Lawyer lawyer){
        PageHelper.startPage(lawyer.getPage(),lawyer.getPageSize());
        List<Lawyer> lawyers = lawyerService.getLawyersByCondition(lawyer);
        PageInfo<Lawyer> pageInfo = new PageInfo<>(lawyers);
        return Response.success(pageInfo);
    }

    /**
     * 编辑律师信息
     * @param lawyer 前端传入
     * @return 响应
     */
    @RequestMapping("/edit")
    public Response<?> editLawyer(@RequestBody Lawyer lawyer){
        int res = lawyerService.editLawyer(lawyer);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 添加律师
     * @param lawyer 律师的相关信息
     * @return 响应
     */
    @RequestMapping("/add")
    public Response<?> addLawyer(@RequestBody Lawyer lawyer){
        // 截取字符串 保存成相对地址
        String[] strs = lawyer.getSelfImage().split("/myImg/");
        String selfImage = strs[strs.length - 1];
        String[] strs1 = lawyer.getSelfImage().split("/myImg/");
        String idCardFrontImage = strs[strs1.length - 1];
        String[] strs2 = lawyer.getSelfImage().split("/myImg/");
        String idCardBackImage = strs[strs2.length - 1];
        String[] strs3 = lawyer.getSelfImage().split("/myImg/");
        String q = strs[strs3.length - 1];
        lawyer.setSelfImage("/myImg/"+selfImage);
        lawyer.setIdCardFrontImg("/myImg/"+idCardFrontImage);
        lawyer.setIdCardBackImg("/myImg/"+idCardBackImage);
        lawyer.setQualificationCertificate("/myImg/"+q);

        int res = lawyerService.addLawyer(lawyer);
        return res==1?Response.success():Response.fail();
    }

    /**
     * 获取律师的个人信息(个人信息)
     * @param realname 律师姓名/真实姓名
     * @return 响应
     */
    @RequestMapping("/get")
    public Response<?> getSelfInfo(String realname){
        System.out.println(realname);
        return Response.success(lawyerService.getSelfInfo(realname));
    }


    // 上传文件
    @Value("${pictureFile.path}")
    private String selfImage;

    @Value("${pictureFile.path-mapping}")
    private String selfImage_mapping;
    //这个写在了配置文件中
    @PostMapping("/upload/selfImage")
    public Response<?> upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUIDutilsu.getUUID() + suffixName; // 新文件名
        File dest = new File(selfImage + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String final_fileName = "http://localhost:8888" + selfImage_mapping + fileName;
        System.out.println(final_fileName);
        return Response.success(final_fileName);
    }

    /**
     * 获取律师的其他信息 荣誉 惩罚 代理案件信息
     * @param selfInfoDto 从前端接收的参数
     * @return 响应
     */
    @RequestMapping("/selfInfo")
    public Response<?> getSelfInfoV2(LawyerSelfInfoDto selfInfoDto){
        System.out.println(selfInfoDto);
        return Response.success(lawyerService.getSelfInfoV2(selfInfoDto));
    }
}


