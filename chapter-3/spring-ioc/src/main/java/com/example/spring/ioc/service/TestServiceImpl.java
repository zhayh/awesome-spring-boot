package com.example.spring.ioc.service;

import com.example.spring.ioc.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2021-2-25 15:49
 * @description :
 */

@Service("testService")
public class TestServiceImpl implements TestService{
    @Resource(name = "testDao")
    private TestDao testDao;
    @Override
    public void save() {
        testDao.save();
        System.out.println("testService save");
    }
}
