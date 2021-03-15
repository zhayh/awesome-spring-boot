package com.example.spring.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : zhayh
 * @date : 2021-3-12 21:47
 * @description : 除0的exception处理
 */

@Controller
public class ExceptionController {
    @GetMapping("/user/{id:\\d+}")
    public String get(@PathVariable String id) {
        throw new RuntimeException();
    }
}
