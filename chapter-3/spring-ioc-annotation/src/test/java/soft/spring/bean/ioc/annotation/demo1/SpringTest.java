package soft.spring.bean.ioc.annotation.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-2-10 15:28
 * @description :
 */
@Slf4j
@SpringBootTest
public class SpringTest {
    @Autowired
    private ValueDemo valueDemo;

    @Autowired
    private UserService service;

    @Test
    public void test1() {
        String str = service.sayHello("张三");
        log.info(str);
    }

    @Test
    public void testEat() {
        service.eat();
    }

    @Test
    public void testSave() {
        service.save();
    }

    @Test
    public void testValueDemo() {
        log.info("获取字符串：{}", valueDemo.getUserName());
        log.info("获取List：{}", valueDemo.getPreferences());
        log.info("获取Map：{}", valueDemo.getProductsCount());
        log.info("获取Map中的特定Key的值：{}", valueDemo.getP1Count());
        log.info("获取系统变量：{}", valueDemo.getJavaHome());
        log.info("设置默认值：{}", valueDemo.getStockCount());

        valueDemo.setUserDetails("niit", "仙林");
        log.info("参数注入：{}, {}", valueDemo.getUserName(), valueDemo.getAddress());
    }
}
