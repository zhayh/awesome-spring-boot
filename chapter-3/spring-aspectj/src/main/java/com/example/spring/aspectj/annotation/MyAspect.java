package com.example.spring.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2021-2-25 21:10
 * @description :
 */

@Aspect
@Component
public class MyAspect {
    /**
     * 定义切入点，通知增强哪些方法
     * 切入点表达式为：execution()
     * 第1个 * - 返回类型，*表示任意类型
     * 第2个 * - 类名，*表示匹配 dao包中所有的类
     * 第3个 * - 方法名，*表示匹配类中所有方法
     * (..) - 方法参数，..表示任意参数
     */
    @Pointcut("execution(* com.example.spring.aspectj.dao.*.*(..))")
    private void myPointCut() {
    }

    /**
     * 前置通知，使用JoinPoint接口作为参数获取目标对象的信息
     * @param joinPoint
     */
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.print("前置通知： 模拟权限控制");
        System.out.println(", 目标类对象： " + joinPoint.getTarget()
                + ", 被增强处理的方法： " + joinPoint.getSignature().getName());
    }

    /**
     * 后置返回通知
     *
     * @param joinPoint
     */
    @AfterReturning("myPointCut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.print("后置返回通知： 模拟删除临时文件");
        System.out.println(", 被增强处理的方法： " + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * ProceedingJoinPoint是JoinPoint的子接口，代表可以执行的目标方法
     * 返回类型必须为Object
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 开始
        System.out.println("环绕开始： 执行目标方法前，模拟开启事务");
        // 执行当前目标方法
        Object object = joinPoint.proceed();
        // 结束
        System.out.println("环绕结束： 执行目标方法后，模拟关闭事务");
        return object;
    }

    /**
     * 异常通知
     *
     * @param e
     */
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void exception(Throwable e) {
        System.out.println("异常通知： 程序执行异常，" + e.getMessage());
    }

    /**
     * 后置通知（最终通知）
     */
    @After("myPointCut()")
    public void after() {
        System.out.println("最终通知：模拟释放资源");
    }
}
