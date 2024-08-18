package com.ychs.lawfirmsys.dto.lawyer;

import lombok.Data;

/**
 * 前台传入的 查询律师的 信息
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/10
 */
@Data
public class LawyerSelfInfoDto {
    private Integer id; // id
    private String realname;    // 律师姓名
}


