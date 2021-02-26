package com.example.spring.ioc.config;

import com.example.spring.ioc.controller.TestController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-25 16:15
 * @description :
 */

public class TestAnnotation {
    public static void main(String[] args) {
        // 初始化Spring容器ApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAnnotation.class);
        // 获取Bean对象
        TestController controller = context.getBean(TestController.class);
        controller.save();
    }
}
