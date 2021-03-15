package com.example.spring.exception;

import com.example.spring.exception.exception.CustomException;
import com.example.spring.exception.exception.CustomExceptionType;
import lombok.Data;

/**
 * @author : zhayh
 * @date : 2021-3-14 10:52
 * @description : 请求接口统一响应数据结构
 */

@Data
public class ResponseResult {
    private boolean isOk;  //请求是否处理成功
    private int code; //请求响应状态码
    private String message;  //请求结果描述信息
    private Object data; //请求结果数据（通常用于查询操作）

    private ResponseResult() {
    }

    //请求出现异常时的响应数据封装
    public static ResponseResult error(CustomException e) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setOk(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    //请求出现异常时的响应数据封装
    public static ResponseResult error(CustomExceptionType customExceptionType,
                                       String errorMessage) {
        ResponseResult resultBean = new ResponseResult();
        resultBean.setOk(false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setOk(true);
        result.setCode(200);
        result.setMessage("请求响应成功!");
        return result;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseResult success(Object obj) {
        ResponseResult result = new ResponseResult();
        result.setOk(true);
        result.setCode(200);
        result.setMessage("请求响应成功!");
        result.setData(obj);
        return result;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseResult success(Object obj, String message) {
        ResponseResult result = new ResponseResult();
        result.setOk(true);
        result.setCode(200);
        result.setMessage(message);
        result.setData(obj);
        return result;
    }
}
