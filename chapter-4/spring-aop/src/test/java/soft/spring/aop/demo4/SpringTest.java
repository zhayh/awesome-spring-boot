package soft.spring.aop.demo4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-11 12:33
 * @description :
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringTest {
//    @Resource(name="customerDao")  //直接调用目标类方法
    @Resource(name = "customerDaoProxy")  // 通过代理调用
    private CustomerDao customerDao;
    @Test
    public void test1() {
        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
    }
}
