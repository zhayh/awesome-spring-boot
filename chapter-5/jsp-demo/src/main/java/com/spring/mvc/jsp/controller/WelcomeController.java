package com.spring.mvc.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zhayh
 * @date : 2020-3-19 21:58
 * @description :
 */

@Controller
@RequestMapping("/")
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model, String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}
