package com.example.spring.configure.service;

import com.example.spring.configure.dao.UserDao;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:49
 * @description :
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save() {
        userDao.save();
        System.out.println("userService save");
    }
}
