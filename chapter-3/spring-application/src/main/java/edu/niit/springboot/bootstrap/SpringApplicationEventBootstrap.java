package edu.niit.springboot.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2020-3-16 19:33
 * @description : Spring 应用事件引导类
 */
@SpringBootApplication
public class SpringApplicationEventBootstrap {
    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        // 启动上下文
        context.refresh();
        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2020");
        context.publishEvent(new ApplicationEvent("病毒") {

        });

        // 关闭上下文
        context.close();
    }
}
