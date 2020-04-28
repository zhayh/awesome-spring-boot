package com.spring.mq.rabbitmq.Consumer;

import com.spring.mq.rabbitmq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-25 07:58
 * @description :
 */
@Slf4j
@Component
//@RabbitListener(queues = Message.ALL_QUEUE)
public class AllTopicConsumer {
    @RabbitHandler
    public void onMessage(Message message) {
        log.info("All Topic Exchage 接收的消息内容： {}", message);
    }
}
