package com.example.spring.bean.service;

/**
 * @author : zhayh
 * @date : 2021-2-26 17:16
 * @description :
 */

//@Service
public class TestService {
//    @PostConstruct
    public void initService() {
        System.out.println("initMethod");
    }

    public TestService() {
        System.out.println("构造方法");
    }

//    @PreDestroy
    public void destroyService() {
        System.out.println("destroyMethod");
    }
}
