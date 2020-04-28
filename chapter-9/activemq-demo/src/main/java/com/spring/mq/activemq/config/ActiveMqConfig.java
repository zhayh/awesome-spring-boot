package com.spring.mq.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author : zhayh
 * @date : 2020-4-24 15:57
 * @description : 配置同时支持 Queue和 Topic
 */

@Configuration
@EnableJms
public class ActiveMqConfig {
    @Bean("queueListenerFactory")
    public JmsListenerContainerFactory<?> queueListenerFactory(
            ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }
    @Bean("topicListenerFactory")
    public JmsListenerContainerFactory<?> topicListenerFactory(
            ActiveMQConnectionFactory  connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置为发布订阅方式
        factory.setPubSubDomain(true);
        return factory;
    }
}
