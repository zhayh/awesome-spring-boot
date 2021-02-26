package com.example.spring.bean;

/**
 * @author : zhayh
 * @date : 2021-2-26 14:30
 * @description :
 */

public class DemoBeanInstanceFactory {
    public DemoBean createDemoBeanInstance() {
        return new DemoBean("调用实例工厂方法实例化Bean");
    }
}
