package com.example.spring.ioc.test;

import com.example.spring.ioc.config.AnnotationConfig;
import com.example.spring.ioc.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-25 16:15
 * @description :
 */

public class AnnotationTest {
    public static void main(String[] args) {
        // 初始化Spring容器ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        // 获取Bean对象
        UserController controller = context.getBean(UserController.class);
        controller.save();
    }
}
