package com.example.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2021-2-27 18:30
 * @description :
 */

@RestController
@RequestMapping("/api")
public class HelloRestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello, spring boot";
    }
}
