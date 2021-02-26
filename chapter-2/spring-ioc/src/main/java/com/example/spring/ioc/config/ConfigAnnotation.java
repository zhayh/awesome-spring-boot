package com.example.spring.ioc.config;

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
@Configuration：声明当前类为一个配置类，相当于一个Spring的XML配置文件
@ComponentScan：自动扫描所定义包下使用的注解，并注册为Bean，相当于Spring的配置文件中使用
                <context:component-scan base-package="com.example.spring.ioc" />
 */
