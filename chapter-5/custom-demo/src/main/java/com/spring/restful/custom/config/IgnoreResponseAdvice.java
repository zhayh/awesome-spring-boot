package com.spring.restful.custom.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : zhayh
 * @date : 2020-3-31 12:00
 * @description : 忽略ResponseAdvice的自定义注解
 */

/**
 * 忽略ResponseAdvice的自定义注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
