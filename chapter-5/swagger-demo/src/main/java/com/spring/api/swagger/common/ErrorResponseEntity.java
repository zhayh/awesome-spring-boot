package com.spring.api.swagger.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
