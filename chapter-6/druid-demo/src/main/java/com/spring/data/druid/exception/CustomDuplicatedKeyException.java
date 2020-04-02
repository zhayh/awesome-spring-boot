package com.spring.data.druid.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author : zhayh
 * @date : 2020-4-1 22:56
 * @description : 自定义的重复主键的异常类
 */

public class CustomDuplicatedKeyException extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
