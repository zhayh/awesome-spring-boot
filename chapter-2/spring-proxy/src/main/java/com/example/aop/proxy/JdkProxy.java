package com.example.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : zhayh
 * @date : 2021-3-9 16:09
 * @description :
 */

public class JdkProxy implements InvocationHandler {
    private UserDao userDao;

    // 创建代理方法
    public Object createProxy(UserDao userDao) {
        this.userDao = userDao;
        // 类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        // 被代理对象实训的所有接口
        Class<?>[] clazz = userDao.getClass().getInterfaces();
        // 使用代理类进行增强，返回代理后的对象
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    /**
     * 所有动态代理类的方法调用都会交给invoke()方法处理
     * @param proxy 被代理后的对象
     * @param method 将要被执行的方法信息（反射）
     * @param args 执行方法需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 声明切面
        MyAspect myAspect = new MyAspect();
        // 前置增强
        myAspect.checkPermissions();
        // 在目标类调用方法，并传入参数
        Object obj = method.invoke(userDao, args);
        // 后置增强
        myAspect.log();
        return obj;
    }
}
