package com.example.spring.bean.test;

import com.example.spring.bean.config.ScopeConfig;
import com.example.spring.bean.service.PrototypeService;
import com.example.spring.bean.service.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-26 15:56
 * @description :
 */

public class TestScope {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScopeConfig.class);
        SingletonService ss1 = context.getBean(SingletonService.class);
        SingletonService ss2 = context.getBean(SingletonService.class);
        System.out.println(ss1);
        System.out.println(ss2);

        PrototypeService ps1 = context.getBean(PrototypeService.class);
        PrototypeService ps2 = context.getBean(PrototypeService.class);
        System.out.println(ps1);
        System.out.println(ps2);

        context.close();
    }
}
