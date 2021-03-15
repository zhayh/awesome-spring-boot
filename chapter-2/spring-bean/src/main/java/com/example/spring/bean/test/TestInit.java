package com.example.spring.bean.test;

import com.example.spring.bean.config.ScopeConfig;
import com.example.spring.bean.service.DemoService;
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
        DemoService service = context.getBean(DemoService.class);
        System.out.println(service);

        context.close();
    }
}
