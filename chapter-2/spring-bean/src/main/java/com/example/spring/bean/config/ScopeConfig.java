package com.example.spring.bean.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2021-2-26 15:55
 * @description :
 */

@Configuration
@ComponentScan("com.example.spring.bean.service")
public class ScopeConfig {
}
