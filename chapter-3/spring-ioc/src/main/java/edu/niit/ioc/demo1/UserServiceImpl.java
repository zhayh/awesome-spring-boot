package edu.niit.ioc.demo1;

/**
 * @author : zhayh
 * @date : 2020-2-10 09:51
 * @description : User接口的实现类
 */
public class UserServiceImpl implements UserService {
    // 添加属性
    private String name;

    @Override
    public void sayHello() {
        System.out.println("Hello Spring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
