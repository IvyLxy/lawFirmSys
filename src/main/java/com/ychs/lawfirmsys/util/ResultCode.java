package com.ychs.lawfirmsys.util;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
/**
 * 枚举类 错误的返回信息
 */
public enum ResultCode {
    SUCCESS(200,"成功"),
    NO_PRIVILEGE(401,"没有权限"),
    NO_LOGIN(403,"用户名/手机号不存在"),
    ERROR_TOKEN(500100,"token有误"),
    OPERATE_ERROR(500101,"操作失败"),
    PWD_ERROR(500102,"新旧密码一致"),
    ERROR(500,"系统异常，请联系管理员");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}

