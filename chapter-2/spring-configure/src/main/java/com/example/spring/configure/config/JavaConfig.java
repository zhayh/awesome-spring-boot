package com.example.spring.configure.config;

import com.example.spring.configure.controller.TestController;
import com.example.spring.configure.dao.TestDao;
import com.example.spring.configure.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:13
 * @description :
 */

@Configuration
public class JavaConfig {
    @Bean
    public TestDao getTestDao() {
        return new TestDao();
    }

    @Bean
    public TestService getTestService() {
        TestService testService = new TestService();
        testService.setTestDao(getTestDao());
        return testService;
    }

    @Bean
    public TestController getTestController() {
        TestController controller = new TestController();
        controller.setTestService(getTestService());
        return controller;
    }
}
