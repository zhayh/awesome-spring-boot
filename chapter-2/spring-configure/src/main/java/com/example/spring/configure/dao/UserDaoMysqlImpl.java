package com.example.spring.configure.dao;

/**
 * @author : zhayh
 * @date : 2021-3-11 11:20
 * @description :
 */

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("UserDaoMysql save");
    }
}
