package com.example.spring.configure.controller;

import com.example.spring.configure.service.TestService;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:11
 * @description :
 */

public class TestController {
    TestService testService;

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public void save() {
        testService.save();
    }
}
