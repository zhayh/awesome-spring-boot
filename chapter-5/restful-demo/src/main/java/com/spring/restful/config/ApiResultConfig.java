package com.spring.restful.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.restful.common.ApiResult;
import com.spring.restful.common.ErrorCode;
import com.spring.restful.pojo.Message;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author : zhayh
 * @date : 2020-3-20 12:23
 * @description : 全局统一响应返回码的处理
 */

@EnableWebMvc
@Configuration
public class ApiResultConfig {
    @RestControllerAdvice("com.spring.restful.controller")
    static class ApiResultResponseAdvice implements ResponseBodyAdvice<Object> {

        private static final Class[] annos = {
                RequestMapping.class,
                GetMapping.class,
                PostMapping.class,
                DeleteMapping.class,
                PutMapping.class
        };
        /**
         *
         * @param returnType
         * @param converterType
         * @return 返回false则不执行当前Advice的业务
         */
        @Override
        public boolean supports(MethodParameter returnType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
            AnnotatedElement element = returnType.getAnnotatedElement();
            Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
            return true;
        }

        /**
         * 处理响应的具体业务方法
         * @param body response信息
         * @param returnType
         * @param selectedContentType
         * @param selectedConverterType
         * @param request
         * @param response
         * @return
         */
        @Override
        public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                      MediaType selectedContentType,
                                      Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                      ServerHttpRequest request,
                                      ServerHttpResponse response) {
            Object result = null;
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            if (body instanceof ApiResult) {
                result = body;
            } else if(body instanceof ErrorCode) {
                ErrorCode errorCode = (ErrorCode) body;
                result =  new ApiResult<>(errorCode.getCode(), errorCode.getMsg(), "");
            } else {
                result = new ApiResult<>(200, "成功", body);
            }
            return result;
        }
    }
}
