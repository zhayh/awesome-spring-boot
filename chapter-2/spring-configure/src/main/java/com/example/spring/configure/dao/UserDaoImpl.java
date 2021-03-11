package com.example.spring.configure.dao;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:46
 * @description :
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao save");
    }
}
