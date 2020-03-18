package soft.spring.aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : zhayh
 * @date : 2020-2-11 10:25
 * @description : 自定义JDK代理类
 */
public class MyJdkProxy implements InvocationHandler {
    private UserDao userDao;

    public MyJdkProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public Object createProxy() {
        return Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName())) {
            System.out.println("权限校验......");
            return method.invoke(userDao, args);
        }
        return method.invoke(userDao, args);
    }
}
