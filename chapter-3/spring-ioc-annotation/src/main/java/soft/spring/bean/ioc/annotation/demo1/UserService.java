package soft.spring.bean.ioc.annotation.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-2-10 15:25
 * @description : Spring的Bean的注解方式
 */

@Service("userService")
public class UserService {
    // 指定默认值
    @Value("米饭")
    private String sth;

//    @Autowired(required = true)
//    @Qualifier("userDao1")
    @Resource(name = "userDao1")
    private UserDao userDao;

    public String sayHello(String name) {
        return "Hello " + name;
    }
    public void eat() {
        System.out.println("eat: " + sth);
    }
    public void save() {
        System.out.println("UserService中保存用户......");
        userDao.save();
    }
}
