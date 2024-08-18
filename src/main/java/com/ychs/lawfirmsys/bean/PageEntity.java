package com.ychs.lawfirmsys.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 分页
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/22
 */
@Data
public class PageEntity {
    @JsonIgnore
    private Integer page;
    @JsonIgnore
    private Integer pageSize;
}


