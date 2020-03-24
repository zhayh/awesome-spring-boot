package com.springboot.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-2-15 22:13
 * @description :
 */

@RestController
@RequestMapping("/api")
public class MyRestController {
    @RequestMapping("/hello")
    public String get() {
        return "Hello Spring Boot";
    }
}
