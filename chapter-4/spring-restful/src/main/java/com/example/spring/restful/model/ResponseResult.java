package com.example.spring.restful.model;

import lombok.Data;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:17
 * @description :
 */

@Data
public class ResponseResult {
    private boolean isOk;  //请求是否处理成功
    private int code; //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data; //请求结果数据（通常用于查询操作）

    private ResponseResult() {
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

//@ApiModel(value = "统一响应的数据结构")
//public class ResponseResult {
//    @ApiModelProperty(value = "请求是否处理成功")
//    private boolean isok;  //请求是否处理成功
//    @ApiModelProperty(value = "请求响应状态码", example = "200, 400, 500")
//    private int code; //请求响应状态码（200、400、500）
//    @ApiModelProperty(value = "请求结果描述信息")
//    private String message;  //请求结果描述信息
//    @ApiModelProperty(value = "请求结果数据")
//    private Object data; //请求结果数据（通常用于查询操作）
