package com.spring.mq.rabbitmq.config;

import com.spring.mq.rabbitmq.model.Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2020-4-24 19:35
 * @description :
 */
//@Configuration
public class RabbitTopicConfig {
    @Bean
    Queue marketingQueue() {
        return new Queue(Message.MARKET_QUEUE, false);
    }

    @Bean
    Queue financeQueue() {
        return new Queue(Message.FINANCE_QUEUE, false);
    }

    @Bean
    Queue adminQueue() {
        return new Queue(Message.ADMIN_QUEUE, false);
    }

    @Bean
    Queue allQueue() {
        return new Queue(Message.ALL_QUEUE, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(Message.TOPIC_EXCHANGE);
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(marketingQueue)
                .to(topicExchange).with("queue.marketing");
    }

    @Bean
    Binding financeBinding(Queue financeQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(financeQueue).to(topicExchange)
                .with("queue.finance");
    }

    @Bean
    Binding adminBinding(Queue adminQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueue).to(topicExchange)
                .with("queue.admin");
    }

    @Bean
    Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueue).to(topicExchange)
                .with("queue.*");
    }
}
