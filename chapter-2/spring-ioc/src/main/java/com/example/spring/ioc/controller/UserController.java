package com.example.spring.ioc.controller;

import com.example.spring.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:51
 * @description :
 */

@Controller
public class UserController {
    // 属性注入（不推荐）
//    @Autowired
    private UserService userService;

    // 构造方法注入（推荐）
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // set方法注入（推荐）
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        userService.save();
        System.out.println("userController save");
    }
}
