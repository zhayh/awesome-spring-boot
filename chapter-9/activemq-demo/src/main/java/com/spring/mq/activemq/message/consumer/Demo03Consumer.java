package com.spring.mq.activemq.message.consumer;

import com.spring.mq.activemq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-24 13:23
 * @description : 消息消费者，可以同时接收队列及订阅消息
 */
@Slf4j
//@Component
public class Demo03Consumer {
    // 接收队列消息
    @JmsListener(destination = "niit.queue", containerFactory = "queueListenerFactory")
    public void receiveQueue(Message message) {
        log.info("Consumer03接收到的队列消息: {}", message);
    }

    // 接收订阅消息
    @JmsListener(destination = "niit.topic", containerFactory = "topicListenerFactory")
    public void receiveTopic(Message message) {
        log.info("Consumer03接收到的订阅消息: {}", message);
    }
}
