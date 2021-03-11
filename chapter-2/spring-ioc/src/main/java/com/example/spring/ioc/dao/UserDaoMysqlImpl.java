package com.example.spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author : zhayh
 * @date : 2021-3-10 11:03
 * @description :
 */

@Repository("userDaoMySql")
public class UserDaoMysqlImpl  implements UserDao{
    @Override
    public void save() {
        System.out.println("mysql UserDao");
    }
}
