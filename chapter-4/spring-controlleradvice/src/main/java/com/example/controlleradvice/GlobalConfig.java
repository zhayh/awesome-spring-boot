package com.example.controlleradvice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2021-3-4 11:35
 * @description :
 */

@ControllerAdvice
public class GlobalConfig {
    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView customException(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("message", e.getMessage());
        return mv;
    }
    /**
     * 全局数据绑定
     * @return
     */
    @ModelAttribute(value = "info")
    public Map<String, String> userInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "张三");
        map.put("gender", "男");
        return map;
    }

    /**
     * 全局数据预处理
     * @param binder
     */
    @InitBinder("book")
    public void initBook(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("author")
    public void initAuthor(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}
