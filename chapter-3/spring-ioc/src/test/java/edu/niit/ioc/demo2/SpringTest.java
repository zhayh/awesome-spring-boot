package edu.niit.ioc.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-2-10 11:20
 * @description : demo2的测试Bean实例化3种方式
 */
public class SpringTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean1 bean = (Bean1) context.getBean("bean1");
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean2 bean = (Bean2) context.getBean("bean2");
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean3 bean = (Bean3) context.getBean("bean3");
    }
}
