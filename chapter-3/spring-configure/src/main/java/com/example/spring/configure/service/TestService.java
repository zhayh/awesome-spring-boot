package com.example.spring.configure.service;

import com.example.spring.configure.dao.TestDao;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:10
 * @description :
 */

public class TestService {
    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public void save() {
        testDao.save();
    }
}
