package com.example.spring.ioc.service;

import com.example.spring.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:49
 * @description :
 */

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
        System.out.println("userService save");
    }

    @Autowired
    @Qualifier(value = "userDaoMySql")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
