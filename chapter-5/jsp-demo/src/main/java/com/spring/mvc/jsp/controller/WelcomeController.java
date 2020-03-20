package com.spring.mvc.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-2-15 21:58
 * @description :
 */

@Controller
public class WelcomeController {
    /**
     * @param model： 存储属性
     * @param name ： 参数
     * @return ： 返回hello跳转到hello.html
     */
    @GetMapping("/hello")
    public String hello(Model model, String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    /**
     * @param model 键值对
     * @param name 参数
     * @return 返回welcome跳转到welcome.jsp
     */
    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model, String name) {
        model.put("name", name);
        model.put("time", LocalDate.now());
        return "welcome";
    }

    /**
     * @return ModelAndView对象到welcome.jsp显示
     */
    @RequestMapping("/other")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("time", LocalDate.now());
        return mv;
    }

    /**
     * @param name 传递的参数
     * @return 返回json字符串
     */
    @RequestMapping("/other2")
    @ResponseBody
    public String welcome(@RequestParam(value = "name", required = false) String name) {
        return name.isEmpty() ? "没传值" : "收到的值为：" + name;
    }
}
