package com.ychs.lawfirmsys.vo;

import lombok.Data;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/5
 */
@Data
public class CaseStatistic {
    private Integer total; // 案件总数

    private String result;  // 结果
    private Integer resTotal;   // 结果对应的案件总数

    private Integer winCount;
    private Integer loseCount;
    private Integer midCount;

    private String typeName;    // 根据Id查询案件类型
    private Integer typeTotal;  // 按类型分组 统计每个类型的案件总数 每个类型的结果统计
}


