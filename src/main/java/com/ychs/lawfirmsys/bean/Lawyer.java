package com.ychs.lawfirmsys.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.time.LocalDate;

/**
 * 律师
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
@Data
public class Lawyer extends PageEntity{
    private Integer id; // 律师id
    private String lawyerName;  // 律师姓名
    private String gender;  // 性别 F女 M男
    private String nation;  // 民族
    private LocalDate birth; // 出生日期
    private String graduateSchool;  // 毕业院校
    private String major;   //专业

    private String edu; // 学历
    private String politics;    // 政治面貌

    private String idCardNum;   // 身份证号
    private String phone;   // 手机号  唯一性校验
    private String email;   // 邮箱
    private String practiceCertificateNum;  // 执业证号
    private LocalDate qualificationDate; // 取得职业资格日期

    private Integer typeId;   // 业务特长类型id
        private String specialty;    // 业务特长名称 typeId -> typeName

    private Boolean isPartner;  // 是否合伙人
    private LocalDate hireDate;  // 聘用时间

    private String lawyerType; // 律师类型

    private String partTimeJob; // 兼职律师工作单位
    private Boolean isRepresentative;   // 是否担任人大代表或政协委员

    private String awards;  // 荣誉
    private String punishment;  // 惩罚
    private Boolean isActive;   // 是否在职
    private String remark;  // 备注

    @Value("${pictureFile.path}")
    private String selfImage;   // 一寸照片
    @Value("${pictureFile.path-mapping}")
    private String selfImage_mapping;
    private String idCardFrontImg;
    private String idCardBackImg;
    private String qualificationCertificate;    //职业执照

    private Integer careerYears; //职业年限

    private String username;    // todo 这个username是啥！！！！！！！！！！！！！！！
}


