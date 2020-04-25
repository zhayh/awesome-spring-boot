package com.spring.mq.rabbitmq.config;

import com.spring.mq.rabbitmq.model.HeaderMessage;
import com.spring.mq.rabbitmq.model.Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2020-4-24 19:35
 * @description :
 */
//@Configuration
public class RabbitHeadersConfig {

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
    HeadersExchange headerExchange() {
        return new HeadersExchange(Message.HEADER_EXCHANGE);
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueue)
                .to(headerExchange)
                .where(HeaderMessage.HEADER_KEY)
                .matches(HeaderMessage.MARKET_HEADER_VALUE);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueue)
                .to(headerExchange)
                .where(HeaderMessage.HEADER_KEY)
                .matches(HeaderMessage.FINANCE_HEADER_VALUE);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, HeadersExchange headerExchange) {
        return BindingBuilder.bind(adminQueue)
                .to(headerExchange)
                .where(HeaderMessage.HEADER_KEY)
                .matches(HeaderMessage.ADMIN_HEADER_VALUE);
    }
}
