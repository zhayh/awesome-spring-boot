package com.example.spring.nonioc;

/**
 * @author : zhayh
 * @Date : 2021-3-9 11:18
 * @Description:
 */

public interface UserService {
    void save();
    void setUserDao(UserDao userDao);
}
