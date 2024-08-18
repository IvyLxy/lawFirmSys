package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/29
 */
@Data
public class Contract extends PageEntity{
    private String contractNum; // 合同编号 主键
    private String contractName;    // 合同名称

    private Integer typeId; // 类型id
    private String contractType;    // 根据typeId查询合同类型

    private BigDecimal contractMoney;   // 合同金额

    private Integer lawyerId;   // 代理律师id
    private String lawyerName;    // 根据lawyerId查询律师

    private LocalDate receiveDate;  // 领用日期
    private String operator;    // 行政主管
    private Boolean state;   // 状态
    private String remark;  // 备注

    // private Integer period; // 所属时间段
    // todo 为什么用String
    private String periodStart; // 所属时间段
    private String periodEnd; // 所属时间段

    private String periodMonth; // 从后台接受的指定年月
}


