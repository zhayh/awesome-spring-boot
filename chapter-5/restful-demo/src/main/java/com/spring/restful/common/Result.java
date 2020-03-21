package com.spring.restful.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

/**
 * @author : zhayh
 * @date : 2020-3-20 12:08
 * @description : 通用返回值类,统一数据响应的返回结果格式
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code = ExceptionType.SUCCESS.getCode();
    private String message = ExceptionType.SUCCESS.getMsg();
    @NonNull
    private T data;

    public static Result<Object> success() {
        return success(null);
    }

    public static Result<Object> success(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage(HttpStatus.OK.getReasonPhrase());
        result.setData(data);
        return result;
    }

    public static Result<Object> fail(String msg) {
        return fail(msg,null);
    }

    public static Result<Object> fail(String msg, Object data) {
        return fail(ExceptionType.SYSTEM_ERROR.getCode(), msg,null);
    }

    public static Result<Object> fail(int code, String msg, Object data) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
