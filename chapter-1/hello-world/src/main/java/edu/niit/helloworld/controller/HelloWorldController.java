package edu.niit.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-2-27 21:27
 * @description :
 */
@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot";
    }

    // 带参数请求
    @GetMapping("/hello/{name}")
    public String hello(String name) {
        return "Hello, " + name;
    }
}
