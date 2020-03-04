package soft.spring.bean.ioc.annotation.demo4;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-2-10 18:00
 * @description :
 */
public class SpringTest4 {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) context.getBean("productService");
        productService.save();

    }
}
