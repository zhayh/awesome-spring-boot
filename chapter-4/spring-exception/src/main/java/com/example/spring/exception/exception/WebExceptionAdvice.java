package com.example.spring.exception.exception;

import com.example.spring.exception.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : zhayh
 * @date : 2021-3-14 11:08
 * @description : 监听Controller异常的类
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionAdvice {
    /**
     * 处理程序员主动转换的自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponseResult customerException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            // 400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            // TODO 将500异常信息持久化处理，方便运维人员处理
            log.error(CustomExceptionType.SYSTEM_ERROR.getDesc());
        }
        return ResponseResult.error(e);
    }

    /**
     * 处理程序员在程序中未能捕获（遗漏的）异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e) {
        // TODO 将异常信息持久化处理，方便运维人员处理
        log.error(e.getMessage());
        return ResponseResult.error(new CustomException(
                CustomExceptionType.OTHER_ERROR));
    }

    /**
     * 处理MethodArgumentNotValidException异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return ResponseResult.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    /**
     * 处理BindException异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseResult handleBindException(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        return ResponseResult.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }
}
