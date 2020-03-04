package soft.spring.bean.ioc.annotation.demo1;

import org.springframework.stereotype.Repository;

/**
 * @author : zhayh
 * @date : 2020-2-10 16:03
 * @description :
 */

@Repository("userDao1")
public class UserDao {
    public void save() {
        System.out.println("UserDao中保存用户......");
    }
}
