package com.example.spring.aspectj.config;

import com.example.spring.aspectj.dao.TestDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-25 22:20
 * @description :
 */

public class AOPTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        TestDao testDao = context.getBean(TestDao.class);
        testDao.save();
        System.out.println("=====================");
        testDao.modify();
        System.out.println("=====================");
        testDao.delete();
        context.close();
    }
}
