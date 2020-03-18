package soft.spring.aop.demo1;

import org.junit.jupiter.api.Test;

/**
 * @author : zhayh
 * @date : 2020-2-11 10:22
 * @description :
 */
public class SpringTest {
    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();
    }
    @Test
    public void demo2() {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
    @Test
    public void test3() {
        UserDao2 dao = new UserDao2();
        UserDao2 proxy = (UserDao2) new MyCglibProxy(dao).createProxy();
        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
