package soft.spring.aspectj.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-2-11 20:45
 * @description : 切面类
 */

@Aspect
@Component
public class MyAspectAnnotation {
//    @Before(value = "execution(* soft.spring.aspectj.demo1.ProductDao.*(..))")
    @Before(value = "savePointcut() || updatePointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知------" + joinPoint);
    }

    @AfterReturning(value = "updatePointcut()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("后置通知------" + result.toString());
    }

    @Around(value = "execution(* soft.spring.aspectj.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知------");
        Object obj = joinPoint.proceed();
        System.out.println("环绕后通知------");
        return obj;
    }

    @AfterThrowing(value = "execution(* soft.spring.aspectj.demo1.ProductDao.findOne(..))",
            throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("异常抛出通知------" + e);
    }

    @After(value = "execution(* soft.spring.aspectj.demo1.ProductDao.findAll(..))")
    public void after() {
        System.out.println("最终通知------");
    }

    @Pointcut(value = "execution(* soft.spring.aspectj.demo1.ProductDao.save(..))")
    private void savePointcut() {}

    @Pointcut(value = "execution(* soft.spring.aspectj.demo1.ProductDao.update(..))")
    private void updatePointcut() {}
}

