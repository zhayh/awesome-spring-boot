package com.spring.mq.rabbitmq.Consumer;

import com.spring.mq.rabbitmq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-24 19:42
 * @description :
 */

@Slf4j
@Component
@RabbitListener(queues = Message.FINANCE_QUEUE)
public class FinanceDirectConsumer {
    @RabbitHandler
    public void onMessage(String message) {
        log.info("Finance Direct Exchange 接收的消息内容： {}", message);
    }
}
