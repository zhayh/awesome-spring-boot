package com.example.spring.aspectj.test;

import com.example.spring.aspectj.config.JavaConfig;
import com.example.spring.aspectj.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-25 22:20
 * @description :
 */

public class AOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        userDao.save();
        System.out.println("=====================");
        userDao.modify();
        System.out.println("=====================");
        userDao.delete();
        context.close();
    }
}
