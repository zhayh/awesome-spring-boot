package edu.niit.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author : zhayh
 * @date : 2020-3-16 17:24
 * @description : AfterHelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After Hello World: " + event.getApplicationContext().getId() +
                ", timestamp: " + event.getTimestamp());
    }
}
