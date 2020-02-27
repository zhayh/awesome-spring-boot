package edu.niit.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description : 标准的Spring MVC控制器
 */
@Controller
@RequestMapping("/springWeb")
@ResponseBody
public class MySpringWebController {
    @RequestMapping("/hello")
    public String hello() {
        return "<h2>Hello, Spring Boot!<h2>";
    }
}
