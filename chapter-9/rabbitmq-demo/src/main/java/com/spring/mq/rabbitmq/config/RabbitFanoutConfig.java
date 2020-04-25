package com.spring.mq.rabbitmq.config;

import com.spring.mq.rabbitmq.model.Message;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author : zhayh
 * @date : 2020-4-24 19:35
 * @description :
 */
@Configuration
public class RabbitFanoutConfig {
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
    FanoutExchange exchange() {
        return new FanoutExchange(Message.FANOUT_EXCHANGE);
    }

    @Bean
    Binding marketingBinding(Queue marketingQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(marketingQueue).to(exchange);
    }

    @Bean
    Binding financeBinding(Queue financeQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(financeQueue).to(exchange);
    }

    @Bean
    Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(adminQueue).to(exchange);
    }
}
