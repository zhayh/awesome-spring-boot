package com.example.spring.configure.controller;

import com.example.spring.configure.service.UserService;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:11
 * @description :
 */

public class UserController {
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        userService.save();
        System.out.println("userController save");
    }
}
