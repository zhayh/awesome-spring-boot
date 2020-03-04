package edu.niit.ioc.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * @author : zhayh
 * @date : 2020-3-4 19:57
 * @description :
 */

public class SpringTest {
    /**
     * 传统方式
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceImpl();
        userService.sayHello();
    }
    /**
     * 使用Spring的xml方式实现
     */
    @Test
    public void test2() {
        // 1. 使用Spring的工厂类
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 2. 通过工厂获取Bean
        UserService userService = (UserService) context.getBean("userService");
        userService.sayHello();
    }

    /**
     * 读取磁盘系统的配置文件
     */
    @Test
    public void test3() {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.sayHello();
    }
    /**
     * 传统方式的工厂类：BeanFactory（已过时，了解）
     */
    @Test
    public void Test4() {
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/applicationContext.xml"));
        UserService userService = (UserService) factory.getBean("userService");
        userService.sayHello();
    }
}
