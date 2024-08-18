package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/31
 */
@Data
public class ContractCancel extends PageEntity{
    private Integer id; //主键

    private String contractNum; // 合同编号
    private String contractName; // 根据合同id查询合同名称

    private String typeName;    //合同类型

    private Integer lawyerId;
    private String lawyerName;    // 根据lawyerId查询律师

    private String cancelReason;    // 注销原因
    private String operator;    // 行政主管
    private LocalDate cancelDate;   // 注销日期
    private String remark;  // 备注

    private String periodStart; // 所属时间段
    private String periodEnd; // 所属时间段

    private String periodMonth; // 指定年月
}


