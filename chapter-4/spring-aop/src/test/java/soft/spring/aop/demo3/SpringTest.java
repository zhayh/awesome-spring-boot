package soft.spring.aop.demo3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-11 12:33
 * @description :
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
//    @Resource(name="studentDao")
    @Resource(name = "studentDaoProxy")
    private StudentDao studentDao;

    @Test
    public void test1() {
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();
    }

}
