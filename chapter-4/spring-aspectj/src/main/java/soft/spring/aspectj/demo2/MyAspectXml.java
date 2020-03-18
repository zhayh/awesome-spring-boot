package soft.spring.aspectj.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author : zhayh
 * @date : 2020-2-12 08:54
 * @description :
 */

public class MyAspectXml {
    // 前置通知
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知------" + joinPoint);
    }
    public void afterReturning(Object result) {
        System.out.println("后置通知------" + result.toString());
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知------");
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知------");
        return obj;
    }
    public void afterThrowing(Throwable e) {
        System.out.println("异常抛出通知------" + e.getMessage());
    }
    public void after() {
        System.out.println("最终通知------");
    }
}
