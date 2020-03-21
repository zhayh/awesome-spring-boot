package com.spring.restful.common;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @author : zhayh
 * @date : 2020-3-20 12:08
 * @description : 通用返回值类,统一数据响应的返回结果格式
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;
}
