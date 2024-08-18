package com.ychs.lawfirmsys.exception;

import com.ychs.lawfirmsys.util.ResultCode;

import lombok.Data;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/18
 */
@Data
public class BussinessException extends RuntimeException{
    private Integer code;
    public BussinessException(ResultCode resultCode){
        // 调用父类带参的构造方法
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }
}


