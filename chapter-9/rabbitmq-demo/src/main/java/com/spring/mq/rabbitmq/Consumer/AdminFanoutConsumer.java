package com.spring.mq.rabbitmq.Consumer;

import com.spring.mq.rabbitmq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-25 09:21
 * @description :
 */

@Slf4j
@Component
//@RabbitListener(queues = Message.ADMIN_QUEUE)
public class AdminFanoutConsumer {
    @RabbitHandler
    public void onMessage(Message message) {
        log.info("Admin Fanout Queue 接收的消息内容: {}", message);
    }
}

