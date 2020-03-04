package edu.niit.ioc.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-2-10 14:42
 * @description :
 */
public class SpringTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CollectionBean bean = (CollectionBean) context.getBean("collectionBean");
        System.out.println(bean);
    }
}
