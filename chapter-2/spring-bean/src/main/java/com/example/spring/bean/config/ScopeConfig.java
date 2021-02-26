package com.example.spring.bean.config;

import com.example.spring.bean.service.TestService;
import org.springframework.context.annotation.Bean;
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

    // 设置初始化和销毁方法
    @Bean(initMethod = "initService", destroyMethod = "destroyService")
    public TestService getService() {
        return new TestService();
    }
}
