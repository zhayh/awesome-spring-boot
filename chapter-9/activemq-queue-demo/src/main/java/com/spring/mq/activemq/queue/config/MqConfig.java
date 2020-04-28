package com.spring.mq.activemq.queue.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author : zhayh
 * @date : 2020-4-24 11:46
 * @description :
 */
@Configuration
public class MqConfig {

    @Bean
    Queue queue() {
        return new ActiveMQQueue("niit.queue");
    }
}
