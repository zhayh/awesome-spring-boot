package soft.spring.aop.demo5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import soft.spring.aop.demo6.CustomerDao;
import soft.spring.aop.demo6.StudentDao;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-11 12:33
 * @description :
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class SpringTest {
    @Resource(name = "studentDao")
    private StudentDao studentDao;
    @Resource(name="customerDao")
    private CustomerDao customerDao;

    @Test
    public void test1() {
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();

        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
    }
}
