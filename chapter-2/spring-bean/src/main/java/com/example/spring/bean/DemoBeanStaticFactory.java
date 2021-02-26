package com.example.spring.bean;

/**
 * @author : zhayh
 * @date : 2021-2-26 14:32
 * @description :
 */

public class DemoBeanStaticFactory {
    private static DemoBean instance = new DemoBean("调用静态工厂方法实例化Bean");

    public static DemoBean createInstance() {
        return instance;
    }
}
