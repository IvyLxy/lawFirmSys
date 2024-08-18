package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

/**
 * 处罚表
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/8
 */
@Data
public class Punishment extends PageEntity{
    private Integer id; // 处罚id
    private LocalDate punishTime;   // 处罚时间
    private String punishReason;   // 处罚原由
    private String punishContent;  // 处罚内容

    private Integer lawyerId;   // 对应律师id

    private String remark;  // 备注
}


