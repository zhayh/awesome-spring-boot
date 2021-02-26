package com.example.spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:46
 * @description :
 */

@Repository("testDao")
public class TestDaoImpl  implements TestDao{
    @Override
    public void save() {
        System.out.println("testDao save");
    }
}
