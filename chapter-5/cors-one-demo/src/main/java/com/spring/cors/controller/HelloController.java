package com.spring.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-3-23 16:00
 * @description :
 */
@RestController
//@CrossOrigin(origins = "http://localhost:8081")
public class HelloController {
    @GetMapping("/doget")
    public String doGet() {
        return "get 请求";
    }
    @PutMapping("/doput")
    public String doPut() {
        return "put 请求";
    }
}
