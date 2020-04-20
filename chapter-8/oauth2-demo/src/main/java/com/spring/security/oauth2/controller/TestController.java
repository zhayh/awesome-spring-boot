package com.spring.security.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-4-17 09:52
 * @description :
 */

@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String hello() {
        return "hello example";
    }
    
    @GetMapping("/admin/hello")
    public String hello() {
        return "hello example";
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello example";
    }
}
