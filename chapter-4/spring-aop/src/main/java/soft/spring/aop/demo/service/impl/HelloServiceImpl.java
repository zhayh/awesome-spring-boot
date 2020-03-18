package soft.spring.aop.demo.service.impl;

import soft.spring.aop.demo.service.HelloService;

/**
 * @author : zhayh
 * @date : 2020-3-17 19:29
 * @description :
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim().isEmpty() ) {
            throw new RuntimeException("parameter is null ! ! ");
        }
        System.out.println("hello " + name);
    }
}
