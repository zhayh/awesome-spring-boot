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
    @Autowired
    private TestService testService;

    public void save() {
        testService.save();
        System.out.println("testController save");
    }
}
