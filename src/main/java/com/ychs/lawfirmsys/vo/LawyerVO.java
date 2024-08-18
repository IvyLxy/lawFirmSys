package com.ychs.lawfirmsys.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/8
 */
@Data
public class LawyerVO {
    private Integer id; // 律师id
    private String lawyerName;  // 律师姓名 ==> user的真实姓名
    private String gender;  // 性别
    private String nation;  // 民族
    private LocalDate birth; // 出生日期
    private String graduateSchool;  // 毕业院校
    private String major;   // 专业
    private String edu; // 学历
    private String politics;    // 政治面貌
    private String idCardNum;   // 身份证号
    private String phone;   // 手机号
    private String email;   // 邮箱
    private String practiceCertificateNum;  // 执业证号 ==> 唯一绑定律师
    private LocalDate qualificationDate; // 取得职业资格日期

    private Integer typeId;   // 业务特长类型 typeId--> typeName
    private String specialty;    // typeName--->业务特长名称

    private Boolean isPartner;  // 是否合伙人
    private LocalDate hireDate;  // 聘用时间
    private String lawyerType; //律师类型 律师/兼职律师
    private String partTimeJob; // 兼职工作地址
    private Boolean isRepresentative;   // 是否人大代表或政协委员会
    private String awards;  // 所受奖励 todo 表格？
    private String punishment;  // 所受惩罚
    private Boolean isActive;   //是否在职

    private String selfImage;
    private String selfImage_mapping;

    private String username;
}


