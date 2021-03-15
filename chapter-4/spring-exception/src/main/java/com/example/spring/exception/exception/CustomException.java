package com.example.spring.exception.exception;

import lombok.Data;

/**
 * @author : zhayh
 * @date : 2021-3-14 10:50
 * @description : 自定义异常类
 */

@Data
public class CustomException extends RuntimeException{
    //异常错误编码
    private int code ;
    //异常信息
    private String message;
    private CustomException(){}

    public CustomException(CustomExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getDesc();
    }

    public CustomException(CustomExceptionType exceptionTypeEnum,
                           String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }
}
