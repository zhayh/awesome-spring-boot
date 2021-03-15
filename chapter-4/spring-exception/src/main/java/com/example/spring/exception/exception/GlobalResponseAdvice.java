package com.example.spring.exception.exception;

import com.example.spring.exception.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author : zhayh
 * @date : 2021-3-14 11:18
 * @description : 统一业务状态与Http协议状态的配置类/
 */
@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {
        //return returnType.hasMethodAnnotation(ResponseBody.class);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (mediaType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            //为HTTP响应结果设置状态码，状态码就是ResponseResult的code，二者达到统一
            // 根据响应结果是否为ResponseResult类型进行区分
            if (body instanceof ResponseResult) {
                response.setStatusCode(HttpStatus.valueOf(((ResponseResult) body).getCode()));
                return body;
            } else {
                response.setStatusCode(HttpStatus.OK);
                return ResponseResult.success(body);
                // controller层的返回值return ResponseResult.success(data)可以改为return data；
            }
        }
        return body;
    }
}
