package soft.spring.aspectj.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soft.spring.aspectj.demo1.ProductDao;

/**
 * @author : zhayh
 * @date : 2020-2-11 21:35
 * @description :
 */

@SpringBootTest
@ContextConfiguration(value = "classpath:applicationContext2.xml")
public class SpringTest2 {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test1() {
        customerDao.save();
        customerDao.update();
        customerDao.delete();
        customerDao.findOne();
        customerDao.findAll();
    }
}
