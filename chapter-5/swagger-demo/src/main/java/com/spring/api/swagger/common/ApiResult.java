package com.spring.restful.common;

import lombok.*;

/**
 * @author : zhayh
 * @date : 2020-3-20 12:08
 * @description : 通用返回值类,统一数据响应的返回结果格式
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {
    private int code = 200;
    private String msg = "成功";
    @NonNull
    private T data;
}
