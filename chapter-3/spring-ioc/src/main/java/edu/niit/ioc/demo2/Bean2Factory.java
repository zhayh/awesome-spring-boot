package edu.niit.ioc.demo2;

/**
 * @author : zhayh
 * @date : 2020-2-10 11:25
 * @description : Bean2的静态工厂
 */
public class Bean2Factory {
    public static Bean2 createBean2() {
        System.out.println("Bean2Factory的方法已执行。。。");
        return new Bean2();
    }
}
