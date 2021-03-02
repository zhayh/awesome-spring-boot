package com.example.spring.json;

import lombok.Data;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:17
 * @description :
 */

@Data
public class ResponseEntity {
    private boolean isSuccess;  //请求是否处理成功
    private int code; //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data; //请求结果数据（通常用于查询操作）

    private ResponseEntity() {
    }

    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static ResponseEntity success() {
        ResponseEntity ajaxResponse = new ResponseEntity();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseEntity success(Object obj) {
        ResponseEntity ajaxResponse = new ResponseEntity();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseEntity success(Object obj, String message) {
        ResponseEntity ajaxResponse = new ResponseEntity();
        ajaxResponse.setSuccess(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}

