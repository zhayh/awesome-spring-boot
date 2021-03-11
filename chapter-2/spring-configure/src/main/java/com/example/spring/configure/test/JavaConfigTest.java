package com.example.spring.configure.test;

import com.example.spring.configure.config.JavaConfig;
import com.example.spring.configure.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:18
 * @description :
 */

public class JavaConfigTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.save();

        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
