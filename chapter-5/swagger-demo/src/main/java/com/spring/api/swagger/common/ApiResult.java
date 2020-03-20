package com.spring.api.swagger.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author : zhayh
 * @date : 2020-3-20 12:08
 * @description : 通用返回值类,统一数据响应的返回结果格式
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "响应信息")
public class ApiResult<T> {
    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MESSAGE = "成功";

    @ApiModelProperty(value = "响应码", required = true)
    private int code = SUCCESS_CODE;

    @ApiModelProperty(value = "响应消息", required = true)
    private String msg = SUCCESS_MESSAGE;

    @NonNull
    @ApiModelProperty(value = "响应数据", required = true, name="data")
    private T data;
}
