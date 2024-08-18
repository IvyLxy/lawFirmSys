package com.ychs.lawfirmsys.exception;


import com.ychs.lawfirmsys.util.Response;
import com.ychs.lawfirmsys.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * todo 7-19 10：20
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/18
 */
//@ControllerAdvice 要求返回的是JSON格式 但它返回的不是
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {
    // 其他的异常
    @ExceptionHandler(value = Exception.class)
    public Response<?> CommonException(Exception e){
        // 默认的日志级别info
        log.error("统一的异常处理",e);
        return Response.fail(ResultCode.ERROR);
    }

    // 具体的异常
    public Response<?> BussinessException(BussinessException e){
        log.error("业务异常",e.getCode(),e.getMessage());
        return Response.fail(e.getCode(),e.getMessage());
    }
}


