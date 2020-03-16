package soft.spring.bean.ioc.annotation.demo2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import soft.spring.bean.ioc.annotation.config.SpringConfig;

/**
 * @author : zhayh
 * @date : 2020-2-10 15:28
 * @description : 通过注解加载配置类获取bean的单元测试
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest1 {
    @Autowired
    private Bean1 bean1;

    @Test
    public void test1() {
        bean1.say();
    }
}
