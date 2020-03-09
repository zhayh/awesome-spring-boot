package edu.niit.helloworld;

import edu.niit.helloworld.controller.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {
    @Autowired
    private HelloWorldApplication application;
    @Autowired
    private HelloWorldController controller;

    @Test
    void contextLoads() {
        // 方法调用的测试，不能模拟http请求
        String str = controller.hello();
        System.out.println(str);
    }

}
