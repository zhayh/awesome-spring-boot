package com.example.spring.aspectj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : zhayh
 * @date : 2021-2-25 22:17
 * @description :
 */

@Configuration
@ComponentScan("com.example.spring.aspectj")
@EnableAspectJAutoProxy // 开启Spring对AspectJ的支持
public class JavaConfig {
}
