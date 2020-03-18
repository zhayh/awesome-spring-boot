package soft.spring.aop.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description : 自定义环绕通知类
 */

public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前增强---------");
        Object obj = invocation.proceed();
        System.out.println("环绕后增强---------");
        return obj;
    }
}
