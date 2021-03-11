package com.example.spring.nonioc;

/**
 * @author : zhayh
 * @date : 2021-3-9 11:17
 * @description :
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存用户数据");
    }

    @Override
    public void get() {
        System.out.println("获取用户数据");
    }
}
