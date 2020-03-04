package edu.niit.ioc.demo2;

/**
 * @author : zhayh
 * @date : 2020-2-10 11:30
 * @description : Bean3的实例工厂
 */
public class Bean3Factory {
    public Bean3 createBean3() {
        System.out.println("Bean3Factory的方法已执行。。。");
        return new Bean3();
    }
}
