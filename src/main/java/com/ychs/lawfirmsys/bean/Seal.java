package com.ychs.lawfirmsys.bean;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

/**
 * 用章表
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/31
 */
@Data
public class Seal extends PageEntity{
    private Integer id;
    private String user;
    private String useReason;
    private LocalDate useDate;
    private String operator;
    private String userSignature;   // 签名

    private String periodStart;
    private String periodEnd;
}


