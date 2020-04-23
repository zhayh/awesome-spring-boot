package com.spring.security.controller;

import com.spring.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-4-13 21:15
 * @description :
 */

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }

//    @Autowired
//    private SecurityService securityService;
//
//    @GetMapping("/hello1")
//    public String hello1() {
//        return securityService.admin();
//    }
//    @GetMapping("/hello2")
//    public String hello2() {
//        return securityService.user();
//    }
//    @GetMapping("/hello3")
//    public String hello3() {
//        return securityService.hello();
//    }
}
