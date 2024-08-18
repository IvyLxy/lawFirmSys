package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

/**
 * 荣誉表
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/8
 */
@Data
public class Awards extends PageEntity{
    private Integer id; // 荣誉id
    private LocalDate getTime;   // 获取省级
    private String awardName;   // 荣誉名称
    private String awardLevel;  // 荣誉等级

    private Integer lawyerId;   // 对应律师id

    private String remark;  // 备注
}


