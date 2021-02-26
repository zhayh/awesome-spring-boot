package com.example.spring.bean.config;

import com.example.spring.bean.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-26 15:56
 * @description :
 */

public class TestInit {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScopeConfig.class);
        TestService service = context.getBean(TestService.class);
        System.out.println(service);

        context.close();
    }
}
