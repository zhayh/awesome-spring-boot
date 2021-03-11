package com.example.spring.aspectj;

import com.example.spring.aspectj.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : zhayh
 * @date : 2021-3-9 19:48
 * @description :
 */

@SpringBootTest
public class AopTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        userDao.save();
    }
}
