package edu.niit.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description : 标准的Spring Boot RESTController
 */
@RestController
@RequestMapping("/api")
public class MySpringBootController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}

