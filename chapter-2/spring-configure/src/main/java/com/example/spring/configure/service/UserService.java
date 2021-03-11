package com.example.spring.configure.service;

import com.example.spring.configure.dao.UserDao;

/**
 * @author : zhayh
 * @Date : 2021-2-25 15:48
 * @Description:
 */

public interface UserService {
    void save();

    void setUserDao(UserDao userDao);
}
