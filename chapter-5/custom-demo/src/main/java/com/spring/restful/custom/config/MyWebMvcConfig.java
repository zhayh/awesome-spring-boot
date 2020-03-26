package com.spring.restful.custom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : zhayh
 * @date : 2020-3-21 19:21
 * @description : 自定义MVC Configurer，不推荐使用
 * 等同：
 * spring.resources.static-locations=classpath:/static/
 * spring.mvc.static-path-pattern=/**
 */

//@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
    }
}
