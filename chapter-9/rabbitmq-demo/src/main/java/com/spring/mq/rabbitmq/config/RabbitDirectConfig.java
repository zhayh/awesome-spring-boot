package com.spring.mq.rabbitmq.config;

import com.spring.mq.rabbitmq.model.Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author : zhayh
 * @date : 2020-4-24 19:35
 * @description :
 */
@Configuration
public class RabbitDirectConfig {
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
    DirectExchange exchange() {
        return new DirectExchange(Message.DIRECT_EXCHANGE);
    }
    @Bean
    Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
        return BindingBuilder.bind(marketingQueue)
                .to(exchange)
                .with(Message.MARKET_ROUTING_KEY);
    }
    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(financeQueue)
                .to(exchange)
                .with(Message.FINANCE_ROUTING_KEY);
    }
    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
        return BindingBuilder.bind(adminQueue)
                .to(exchange)
                .with(Message.ADMIN_ROUTING_KEY);
    }
}
