package com.spring.api.swagger.exception;

import com.spring.api.swagger.common.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author : zhayh
 * @date : 2020-3-21 09:24
 * @description : 通用的业务异常
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
    /**
     * 错误码
     */
    protected Integer code;
    /**
     * 错误信息
     */
    protected String message;

    public CustomException(ExceptionType type) {
        this.code = type.getCode();
        this.message = type.getMsg();
    }
}
