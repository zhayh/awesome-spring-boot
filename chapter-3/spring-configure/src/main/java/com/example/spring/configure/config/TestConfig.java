package com.example.spring.configure.config;

import com.example.spring.configure.controller.TestController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:18
 * @description :
 */

public class TestConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        TestController controller = context.getBean(TestController.class);
        controller.save();
    }
}
