package com.example.aop.proxy;

/**
 * @author : zhayh
 * @date : 2021-3-9 16:30
 * @description :
 */

public class ProxyTest {
    public static void main(String[] args) {
        // 创建代理对象
        JdkProxy proxy = new JdkProxy();
        // 创建目标对象
        UserDao userDao = new UserDaoImpl();
        // 从代理对象中获取增强后的目标对象
        UserDao proxyUserDao = (UserDao) proxy.createProxy(userDao);
        // 执行方法
        proxyUserDao.add();
        proxyUserDao.sub();
    }
}
