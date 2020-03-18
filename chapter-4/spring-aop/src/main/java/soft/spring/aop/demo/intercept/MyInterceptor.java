package soft.spring.aop.demo.intercept;

import soft.spring.aop.demo.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : zhayh
 * @date : 2020-3-17 19:38
 * @description : 自定义拦截器
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ......");
    }

    @Override
    public Object around(Invocation invocation)
            throws InvocationTargetException, IllegalAccessException {
        System.out.println("around ......");
        Object obj = invocation.proceed();
        System.out.println("around after ......");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
