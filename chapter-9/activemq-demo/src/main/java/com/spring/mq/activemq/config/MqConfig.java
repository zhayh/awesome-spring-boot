package com.spring.mq.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

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

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("niit.topic");
    }
}
