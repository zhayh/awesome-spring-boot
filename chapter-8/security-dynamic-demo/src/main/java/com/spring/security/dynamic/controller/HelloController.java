package com.spring.security.dynamic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-4-15 22:14
 * @description :
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello db";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
}
