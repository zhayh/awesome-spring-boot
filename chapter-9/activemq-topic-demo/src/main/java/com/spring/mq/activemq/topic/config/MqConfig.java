package com.spring.mq.activemq.topic.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @author : zhayh
 * @date : 2020-4-24 11:46
 * @description :
 */
@Configuration
public class MqConfig {
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("niit.topic");
    }
}

