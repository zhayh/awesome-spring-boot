package com.example.spring.mvc.controller;

import com.example.spring.mvc.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author : zhayh
 * @date : 2021-2-27 15:15
 * @description :
 */
@Slf4j
@Controller
@RequestMapping("/")
public class ModelViewController {
    @RequestMapping("/doModelAndView")
    public String doModelAndView(Model model) {
        model.addAttribute("username", "jason");
        model.addAttribute("state", true);
        return "view";
    }

    // 接收参数
    // 请求字符串： ？name=南京
    @GetMapping("/param01")
    @ResponseBody
    public String doMethodParam(String name) {
        return "request params: " + name;
    }

    // 请求字符串： ？name=南京&age=20
    // User对象需提供与参数名相匹配的set方法
    @GetMapping("/param02")
    @ResponseBody
    public String doMethodParam(User user) {
        log.info(user.toString());
        return "request params: " + user;
    }

    @PostMapping(value = "/post")
    @ResponseBody
    public String post(@RequestParam(name = "name") String name,
                       @RequestParam(name = "age") Integer age) {
        String content = String.format("name = %s,age = %d", name, age);
        log.info(content);
        return content;
    }

    // 500异常的默认处理
    @GetMapping("/exception")
    public String get(@RequestParam("id") String id) {
        throw new RuntimeException();
    }

}
