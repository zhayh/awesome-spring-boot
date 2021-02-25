package com.example.spring.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:57
 * @description :
 */

@Configuration
@ComponentScan("com.example.spring.ioc")
public class ConfigAnnotation {
}

/*
@Configuration：声明当前类为一个配置类
 */
