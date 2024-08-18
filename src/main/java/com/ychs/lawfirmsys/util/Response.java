package com.ychs.lawfirmsys.util;

import lombok.Getter;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@Getter
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    //todo 1 为什么写？
    public Response(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
    public Response(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

//      不带参数的成功——编辑
     
    public static Response success(){
        return new Response(ResultCode.SUCCESS,null);
    }

     // 带参数的成功返回——查询
    public static Response success(Object data){
        return new Response(ResultCode.SUCCESS,data);
    }
    // 不带参数的失败
    public static Response fail(){
        return new Response(ResultCode.ERROR,null);
    }
    public static Response fail(ResultCode resultCode){
        return new Response(resultCode,null);
    }
    public static Response fail(Integer code, String msg){
        return new Response(code,msg);
    }
    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}


