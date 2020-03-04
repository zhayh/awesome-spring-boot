package soft.spring.bean.ioc.annotation.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:29
 * @description :
 */
public class SpringTest3 {

    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfiguration.class);
        CustomDao customDao = context.getBean(CustomDao.class);
        customDao.save();
    }
}
