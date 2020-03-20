package com.spring.restful.common;

/**
 * @author : zhayh
 * @date : 2020-3-20 14:02
 * @description : 错误码定义
 */

public enum ErrorCode {
    SUCCESS(200, "成功"),
    PARAM_ERROR(100, "请求参数有误"),
    AUTH_ERROR(101, "未授权"),
    FORBIDEN_ERROR(102, "禁止访问"),
    URL_ERROR(103, "请求路径不存在"),
    SERVER_ERROR(104, "服务器内部错误");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
