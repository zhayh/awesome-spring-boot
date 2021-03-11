package com.example.aop.proxy;

/**
 * @author : zhayh
 * @date : 2021-3-9 16:07
 * @description :
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("添加用户");
    }

    @Override
    public void sub() {
        System.out.println("减少用户");
    }
}
