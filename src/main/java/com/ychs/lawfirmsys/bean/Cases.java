package com.ychs.lawfirmsys.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 案件表
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Cases extends PageEntity{
    private Integer id; // 案件id
    private LocalDate occurrentYear; // 年份
    private String contractNum; // 合同编号 唯一确定
    private String caseName;    // 案件名称

    private Integer typeId; // 类型id(type表) ==> 案件类型
    private String typeName;    // 根据Id查询案件类型
    private Integer typeTotal;  // 每个类型的案件总数

    private Integer lawyerId;   // 律师id
    private String lawyerName;  // 律师姓名

    private String agentType;   // 代理类型 原告/被告
    private String court;   // 开庭法院
    private LocalDate juridicalDays; // 开庭年月

    private Boolean state;   // 状态 true(1) 已结案 false(0)进行中

    private String result;  // 结果 胜诉/败诉/调解
    private Integer resTotal;   // 结果对应的案件总数

    private String periodMonth; //指定年月

    private Integer total; // 所有案件总数

    private Integer winCount;   // 胜利的案件总数
    private Integer loseCount;  // 失败...
    private Integer midCount;   // 调解...
}


