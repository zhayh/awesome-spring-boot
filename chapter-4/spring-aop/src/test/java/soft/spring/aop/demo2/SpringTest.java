package soft.spring.aop.demo2;

import org.junit.jupiter.api.Test;

/**
 * @author : zhayh
 * @date : 2020-2-11 10:47
 * @description :
 */
public class SpringTest {
    @Test
    public void demo1() {
        ProductDao userDao = new ProductDao();
        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();
    }
    @Test
    public void demo2() {
        ProductDao productDao = new ProductDao();
        ProductDao proxy = (ProductDao) new MyCglibProxy(productDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
