package com.example.spring.restful.model;

/**
 * @author : zhayh
 * @date : 2021-3-13 23:12
 * @description : 返回码枚举类
 */

public enum ResponseCode {
    //系统基本码
    SER_INPUT_ERROR(400, "输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员！");

    ResponseCode(int code, String desc) {
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
