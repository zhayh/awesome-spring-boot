package com.example.spring.nonioc;

/**
 * @author : zhayh
 * @date : 2021-3-9 11:42
 * @description :
 */

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("MySQL保存用户数据");
    }

    @Override
    public void get() {
        System.out.println("MySQL获取用户数据");
    }
}
