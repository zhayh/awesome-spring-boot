package com.example.spring.ioc.controller;

import com.example.spring.ioc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:51
 * @description :
 */

@Controller
public class TestController {
    // 属性注入（不推荐）
    // @Autowired
    private final TestService testService;

    // 构造方法注入（推荐）
    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    public void save() {
        testService.save();
        System.out.println("testController save");
    }

    // set方法注入
//    @Autowired
//    public void setTestService(TestService testService) {
//        this.testService = testService;
//    }
}
