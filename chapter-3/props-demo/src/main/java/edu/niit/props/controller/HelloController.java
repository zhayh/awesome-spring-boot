package edu.niit.props.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-2-28 15:07
 * @description :
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello everybody!";
    }
}
