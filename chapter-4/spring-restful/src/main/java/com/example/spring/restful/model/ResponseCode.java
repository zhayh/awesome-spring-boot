package com.example.spring.restful.model;

/**
 * @author : zhayh
 * @date : 2021-3-13 23:12
 * @description : 返回码枚举类
 */

public enum ResponseCode {
    //系统基本码
    SUCCESS(200, "请求响应成功!"),
    USER_INPUT_ERROR(400,"用户输入异常"),
    SERVER_ERROR(500,"系统服务异常"),
    NOT_FOUND_ERROR (404,"没找到"),
    OTHER_ERROR(999,"其他未知异常"),
    ;

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
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
