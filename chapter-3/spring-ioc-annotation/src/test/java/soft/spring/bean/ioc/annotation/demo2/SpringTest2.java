package soft.spring.bean.ioc.annotation.demo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import soft.spring.bean.ioc.annotation.config.SpringConfig;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-10 15:28
 * @description : Spring注解的单元测试
 */
public class SpringTest2 {
    /**
     * 通过配置文件加载 ApplicationContext，获取bean
     */
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        bean1.say();
        context.close();
    }

    /**
     * 通过配置类加载 ApplicationContext，获取bean
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        bean1.say();
        context.close();
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean2 bean1 = (Bean2) context.getBean("bean2");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean1 == bean2);
    }

}
