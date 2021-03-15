package com.example.spring.exception.exception;

/**
 * @author : zhayh
 * @date : 2021-3-14 10:47
 * @description : 异常的枚举类型
 */

public enum CustomExceptionType {
    USER_INPUT_ERROR(400, "输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员！");

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String desc;//异常类型中文描述
    private int code;   //code

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
