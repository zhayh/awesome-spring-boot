package com.example.spring.nonioc;

/**
 * @author : zhayh
 * @date : 2021-3-9 11:19
 * @description :
 */

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
