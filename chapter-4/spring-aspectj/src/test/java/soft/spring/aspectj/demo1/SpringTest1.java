package soft.spring.aspectj.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : zhayh
 * @date : 2020-2-11 21:35
 * @description :
 */

@SpringBootTest
public class SpringTest1 {
    @Autowired
    private ProductDao productDao;

    @Test
    public void test1() {
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.findOne();
        productDao.findAll();
    }
}
